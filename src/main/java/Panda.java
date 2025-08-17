import java.util.Scanner;

public class Panda {
    private static final String NAME = "Panda";
    private static final String LINES = "-".repeat(50);

    private static void generateLines() {
        System.out.println("\n" + LINES);
    }

    private static <T> void reply(T message) {
        generateLines();
        System.out.println(message);
        generateLines();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList tasks = new TaskList();
        String taskAdded = "Got it. I've added this task: \n  ";
        String numTasks = "Now you have " + tasks.size() + " in the list.";
        generateLines();
        System.out.println("Hello I'm " + NAME + "\nWhat can I do for you?");
        generateLines();
        programLoop:
        while (true) {
            String input = scanner.nextLine();
            String[] strArray = input.split(" ", 2);
            String action = strArray[0];
            switch (action) {
                case "bye":
                    reply("Bye. Hope to see you again soon!");
                    break programLoop;
                case "list":
                    reply(tasks);
                    break;
                case "mark":
                    tasks.changeStatus(strArray[1]);
                    reply("Nice! I've marked this task as done:\n  "
                            + tasks.getTask(strArray[1]));
                    break;
                case "unmark":
                    tasks.changeStatus(strArray[1]);
                    reply("Okay, I've marked this task as not done yet:\n  "
                            + tasks.getTask(strArray[1]));
                    break;
                case "todo":
                    Task todo = new ToDo(strArray[1]);
                    tasks.addTask(todo);
                    reply(taskAdded + todo + numTasks);
                    break;
                case "deadline":
                    String[] infoDeadline = strArray[1].split(" /by ");
                    Task deadline = new Deadline(infoDeadline[0], infoDeadline[1]);
                    tasks.addTask(deadline);
                    reply(taskAdded + deadline + numTasks);
                    break;
                case "event":
                    String[] infoEvent = strArray[1].split(" /from | /to ");
                    Task event = new Event(infoEvent[0], infoEvent[1], infoEvent[2]);
                    tasks.addTask(event);
                    reply(taskAdded + event + numTasks);
                    break;
            }
        }
    }
}