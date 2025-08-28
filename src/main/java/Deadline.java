import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected String type;
    protected LocalDate deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.type = "[D]";
        this.deadline = LocalDate.parse(deadline);
    }

    public Deadline(String status, String description, String deadline) {
        super(status, description);
        this.type = "[D]";
        this.deadline = LocalDate.parse(deadline,  DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
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
