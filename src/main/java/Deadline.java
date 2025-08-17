public class Deadline extends Task {
    protected String type;
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.type = "[D]";
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return type + super.toString() + " (by: " + deadline + ")";
    }
}
