package panda.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import panda.PandaException;

/**
 * Deadline is a subclass of Task, with additional information of
 * task type and deadline.
 */
public class Deadline extends Task {
    protected String type;
    protected LocalDate deadline;

    /**
     * Constructs Deadline object based on info from user.
     *
     * @param description Description of task.
     * @param deadline Deadline to complete task.
     * @throws PandaException If the date format is wrong.
     */
    public Deadline(String description, String deadline) throws PandaException {
        super(description);
        this.type = "[D]";
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            throw new PandaException("wrongDateFormat", "");
        }
    }

    /**
     * Constructs Deadline object based on info from text file.
     *
     * @param status Status of task completion.
     * @param description Description of task.
     * @param deadline Deadline to complete task.
     */
    public Deadline(String status, String description, String deadline) {
        super(status, description);
        this.type = "[D]";
        this.deadline = LocalDate.parse(deadline, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    private String formatDate() {
        return deadline.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description + "\u2022" + formatDate() + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString() + " (by: " + formatDate() + ")";
    }
}
