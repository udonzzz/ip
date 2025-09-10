package panda;

import java.util.ArrayList;
import java.util.List;

/**
 * PandaException handles all exceptions that arise from incorrect user input.
 */
public class PandaException extends Exception {
    private static final ArrayList<String> errorList = new ArrayList<>(List.of("add", "list", "mark",
            "unmark", "delete", "find", "todo", "deadline", "event", "wrongDateFormat"));

    private static final String UNKNOWN_ACTION = "OOPS!!! I'm sorry, but I don't know what that means :-("
            + "\nType \"help\" if you are unsure!";
    private static final String WRONG_DATE_FORMAT = "Please provide a valid date in the format yyyy-MM-dd!";
    private static final String DEADLINE_TASK_FORMAT = "OOPS!!! Please provide the deadline as such: \n"
            + "deadline (insert description) /by (insert deadline)";
    private static final String EVENT_TASK_FORMAT = "OOPS!!! Please provide the event as such: \n"
            + "event (insert description) /from (insert start date) /to (insert end date)";
    private static final String UNKNOWN_ERROR = "OOPS!!! Unknown error occurred";

    public PandaException(String action, String description) {
        super(createMessage(action, description));
    }

    private static String createMessage(String action, String description) {
        if (!errorList.contains(action)) {
            return UNKNOWN_ACTION;
        }
        if (action.equals("mark") || action.equals("unmark") || action.equals("delete")) {
            return "OOPS!!! " + action + " needs to be provided an integer as such: \n"
                    + action + " (insert list no. of task to " + action + ")";
        }
        if (action.equals("wrongDateFormat")) {
            return WRONG_DATE_FORMAT;
        }
        if (description.isEmpty()) {
            return "OOPS!!! The description of a " + action + " cannot be empty.";
        }
        if (action.equals("deadline")) {
            return DEADLINE_TASK_FORMAT;
        }
        if (action.equals("event")) {
            return EVENT_TASK_FORMAT;
        }
        return UNKNOWN_ERROR;
    }
}
