package panda;

import panda.task.Task;

import java.util.Scanner;

/**
 * PandaUi handles all interactions with the user, apart from
 * exception messages that arise from user input that are formatted wrongly.
 * */
public class PandaUi {
    private static final String NAME = "Panda";
    private static final String LINES = "_".repeat(90) + "\n";
    private static final String GREETING = "Hello I'm " + NAME + "\nWhat can I do for you?";
    private static final String ADDED_TASK = "Got it. I've added this task: \n  ";
    private static final String BYE = "Bye. Hope to see you again soon!";
    private static final String MARKED_TASK = "Nice! I've marked this task as done:\n  ";
    private static final String UNMARKED_TASK = "Okay, I've marked this task as not done yet:\n  ";
    private static final String DELETED_TASK = "Noted. I've removed this task:\n  ";
    private static final String LOAD_ERROR = "IO Error: Invalid data format in file, data will not be loaded!";
    private static final String SAVE_ERROR = "IO Error: Task data could not be saved to panda.txt.";

    private final Scanner scanner;

    public PandaUi() {
        scanner = new Scanner(System.in);
    }

    public <T> void reply(T message) {
        System.out.println(LINES + message + "\n" + LINES);
    }

    public String getUserInput() {
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

    public void loadError() {
        reply(LOAD_ERROR);
    }

    public void saveError() {
        reply(SAVE_ERROR);
    }

    public void pandaError(PandaException e) {
        reply(e.getMessage());
    }
}
