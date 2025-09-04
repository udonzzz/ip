package panda;

import java.util.ArrayList;
import java.util.List;

/**
 * PandaException handles all exceptions that arise from incorrect user input.
 */
public class PandaException extends Exception {
    private static final ArrayList<String> errorList = new ArrayList<>(List.of("add", "list", "mark",
            "unmark", "delete", "find", "todo", "deadline", "event", "wrongDateFormat"));

    public PandaException(String action, String description) {
        super(createMessage(action, description));
    }

    private static String createMessage(String action, String description) {
        if (!errorList.contains(action)) {
            return "OOPS!!! I'm sorry, but I don't know what that means :-(";
        }
        if (action.equals("mark") || action.equals("unmark") || action.equals("delete")) {
            return "OOPS!!! " + action + " needs to be provided an integer as such: \n"
                    + action + " (insert list no. of task to " + action + ")";
        }
        if (action.equals("wrongDateFormat")) {
            return "Please provide a valid date in the format yyyy-MM-dd!";
        }
        if (description.isEmpty()) {
            return "OOPS!!! The description of a " + action + " cannot be empty.";
        }
        if (action.equals("deadline")) {
            return "OOPS!!! Please provide the deadline as such: \n"
                    + "deadline (insert description) /by (insert deadline)";
        }
        if (action.equals("event")) {
            return "OOPS!!! Please provide the duration as such: \n"
                    + "event (insert description) /from (insert start date) /to (insert end date)";
        }
        return "OOPS!!! Unknown error occurred";
    }
}
