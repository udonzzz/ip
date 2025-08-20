import java.util.Scanner;

public class Panda {
    private static final String NAME = "Panda";
    private static final String LINES = "_".repeat(60) + "\n";

    private static <T> void reply(T message) {
        System.out.println(LINES + message + "\n" + LINES);
    }

    private static boolean arraySizeWrong(String[] array, int expectedSize) {
        return  array.length != expectedSize;
    }

    public static void main(String[] args) throws PandaException {
        Scanner scanner = new Scanner(System.in);
        TaskList tasks = new TaskList();
        String taskAdded = "Got it. I've added this task: \n  ";
        reply("Hello I'm " + NAME + "\nWhat can I do for you?");
        programLoop:
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] strArray = input.split(" ", 2);
                String action = strArray[0];
                if (action.equals("bye")) {
                    reply("Bye. Hope to see you again soon!");
                    break programLoop;
                }
                if (action.equals("list")) {
                    reply(tasks);
                    continue;
                }
                if (arraySizeWrong(strArray, 2)) {
                    throw new PandaException(action, "");
                }
                if (action.equals("mark")) {
                    Task task = tasks.changeStatus(strArray[1], action);
                    reply("Nice! I've marked this task as done:\n  " + task);
                    continue;
                }
                if (action.equals("unmark")) {
                    Task task = tasks.changeStatus(strArray[1], action);
                    reply("Okay, I've marked this task as not done yet:\n  " + task);
                    continue;
                }
                if (action.equals("delete")) {
                    Task task = tasks.deleteTask(strArray[1]);
                    reply("Noted. I've removed this task:\n  " + task + "\nNow you have "
                            + tasks.size() + " tasks in the list.");
                    continue;
                }
                if (action.equals("todo")) {
                    Task todo = tasks.addTask(new ToDo(strArray[1]));
                    reply(taskAdded + todo + "\nNow you have "
                            + tasks.size() + " tasks in the list.");
                    continue;
                }
                if (action.equals("deadline")) {
                    String[] infoDeadline = strArray[1].split(" /by ");
                    if (arraySizeWrong(infoDeadline, 2)) {
                        throw new PandaException(action, infoDeadline[0]);
                    }
                    Task deadline = tasks.addTask(new Deadline(infoDeadline[0], infoDeadline[1]));
                    reply(taskAdded + deadline + "\nNow you have "
                            + tasks.size() + " tasks in the list.");
                    continue;
                }
                if (action.equals("event")) {
                    String[] infoEvent = strArray[1].split(" /from | /to ");
                    if (arraySizeWrong(infoEvent, 3)) {
                        throw new PandaException(action, infoEvent[0]);
                    }
                    Task event = tasks.addTask(new Event(infoEvent[0], infoEvent[1], infoEvent[2]));
                    reply(taskAdded + event + "\nNow you have "
                            + tasks.size() + " tasks in the list.");
                    continue;
                }
                throw new PandaException(action, "");
            } catch (PandaException e) {
                reply(e.getMessage());
            }
        }
    }
}