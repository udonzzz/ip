package panda;

import panda.action.AddAction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {

    @Test
    public void parseUserInput_addDeadline_exceptionThrown() {
        String action = "deadline";
        String[] taskInfo = {"test by 2025-09-01"};
        String input = "deadline test by 2025-09-01";
        String exceptionMessage = "OOPS!!! Please provide the deadline as such: \n"
                + "deadline (insert description) /by (insert deadline)";
        try {
            assertEquals(new AddAction(action, taskInfo), new InputParser().parseUserInput(input));
        } catch (PandaException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }
}
