import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    protected String type;
    protected LocalDate start;
    protected LocalDate end;

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

    public Event(String status, String description, String start, String end) {
        super(status, description);
        this.type = "[E]";
        this.start = LocalDate.parse(start, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        this.end = LocalDate.parse(end, DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description
                + "\u2022" + formatDate(start) +  "\u2022" + formatDate(end) + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString() + " (from: " + formatDate(start) + " to: "  + formatDate(end) + ")";
    }
}
