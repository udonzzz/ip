package panda.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import panda.PandaException;

/**
 * Event is a subclass of Task, with additional information of
 * task type, and start and end date.
 */
public class Event extends Task {
    protected String type;
    protected LocalDate start;
    protected LocalDate end;

    /**
     * Constructs Event object based on info from user.
     *
     * @param description Description of task.
     * @param start Start date of task.
     * @param end End date of task.
     * @throws PandaException If the date format is wrong.
     */
    public Event(String description, String start, String end) throws PandaException {
        super(description);
        this.type = "[E]";
        try {
            this.start = LocalDate.parse(start);
            this.end = LocalDate.parse(end);
        } catch (DateTimeParseException e) {
            throw new PandaException("wrongDateFormat", "");
        }
    }

    /**
     * Constructs Event object based on info from text file.
     *
     * @param status Status of task.
     * @param description Description of task.
     * @param start Start date of task.
     * @param end End date of task.
     */
    public Event(String status, String description, String start, String end) {
        super(status, description);
        this.type = "[E]";
        this.start = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        this.end = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    /**
     * Returns the event info in a format for saving to text file.
     *
     * @return String of event info.
     */
    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description
                + "\u2022" + formatDate(start) + "\u2022" + formatDate(end) + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString() + " (from: " + formatDate(start) + " to: " + formatDate(end) + ")";
    }
}
