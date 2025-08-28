public class Deadline extends Task {
    protected String type;
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.type = "[D]";
        this.deadline = deadline;
    }

    public Deadline(String status, String description, String deadline) {
        super(status, description);
        this.type = "[D]";
        this.deadline = deadline;
    }

    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description + "\u2022" + deadline + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString() + " (by: " + deadline + ")";
    }
}
