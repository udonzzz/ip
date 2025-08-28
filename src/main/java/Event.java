public class Event extends Task {
    protected String type;
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        this.type = "[E]";
        this.start = start;
        this.end = end;
    }

    public Event(String status, String description, String start, String end) {
        super(status, description);
        this.type = "[E]";
        this.start = start;
        this.end = end;
    }

    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description
                + "\u2022" + start +  "\u2022" + end + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString() + " (from: " + start + " to: "  + end + ")";
    }
}
