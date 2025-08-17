public class Event extends Task {
    protected String type;
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        this.status = "[E]";
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return type + super.toString() + "(from: " + start + " to: "  + end + ")";
    }
}
