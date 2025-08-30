package panda.task;

import panda.PandaException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeadlineTest {

    @Test
    public void parseDate_invalidDate_exceptionThrown() {
        String exceptionMessage = "Please provide a valid date in the format yyyy-MM-dd!";
        try {
            assertNotNull(new Deadline("test", "01-09-2025"));
        } catch (PandaException e) {
            assertEquals(exceptionMessage, e.getMessage());
        }
    }
}
