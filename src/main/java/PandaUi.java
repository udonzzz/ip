import java.util.Scanner;

public class PandaUi {
    private static final String NAME = "Panda";
    private static final String LINES = "_".repeat(90) + "\n";
    private static final String GREETING = "Hello I'm " + NAME + "\nWhat can I do for you?";
    private static final String ADDED_TASK = "Got it. I've added this task: \n  ";
    private static final String BYE = "Bye. Hope to see you again soon!";
    private static final String MARKED_TASK = "Nice! I've marked this task as done:\n  ";
    private static final String UNMARKED_TASK = "Okay, I've marked this task as not done yet:\n  ";
    private static final String DELETED_TASK = "Noted. I've removed this task:\n  ";
    private static final String WRONG_DATE_FORMAT = "Please provide a valid date in the format yyyy-MM-dd!";
    private static final String IO_ERROR = "IO Error: Invalid data format! \n"
            + "If you are able to restore the data properly, type \"1\" to exit program.\n"
            + "Otherwise, type anything else, and existing data will be erased before program continues!";

    private final Scanner scanner;

    public PandaUi() {
        scanner = new Scanner(System.in);
    }

    public <T> void reply(T message) {
        System.out.println(LINES + message + "\n" + LINES);
    }

    public String userInput() {
        return scanner.nextLine();
    }

    public void greet() {
        reply(GREETING);
    }

    private String tasksSize(TaskList tasks) {
        return "\nNow you have " + tasks.size() + " tasks in the list.";
    }

    public void taskAdded(Task task, TaskList tasks) {
        reply(ADDED_TASK + task + tasksSize(tasks));
    }

    public void taskDeleted(Task task, TaskList tasks) {
        reply(DELETED_TASK + task + tasksSize(tasks));
    }

    public void bye() {
        reply(BYE);
    }

    public void taskMarked(Task task) {
        reply(MARKED_TASK + task);
    }

    public void taskUnmarked(Task task) {
        reply(UNMARKED_TASK + task);
    }

    public void wrongDateFormat() {
        reply(WRONG_DATE_FORMAT);
    }

    public void ioError() {
        reply(IO_ERROR);
    }

    public void pandaError(PandaException e) {
        reply(e.getMessage());
    }
}
