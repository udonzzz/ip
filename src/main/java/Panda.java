import java.util.Scanner;

public class Panda {
    private static final String NAME = "Panda";
    private static final String LINES = "-".repeat(50);

    private static void generateLines() {
        System.out.println("\n" + LINES);
    }

    private static void reply(String output) {
        generateLines();
        System.out.println(output);
        generateLines();
    }

    private static void reply(TaskList tasks) {
        generateLines();
        System.out.println(tasks);
        generateLines();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList tasks = new TaskList();
        generateLines();
        System.out.println("Hello I'm " + NAME + "\nWhat can I do for you?");
        generateLines();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                reply("Bye. Hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                reply(tasks);
                continue;
            }
            tasks.addTask(input);
            reply("added: " + input);
        }
    }
}