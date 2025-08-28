public class ToDo extends Task {
    protected String type;

    public ToDo(String description) {
        super(description);
        this.type = "[T]";
    }

    public ToDo(String status, String description) {
        super(status, description);
        this.type = "[T]";
    }

    public String writeToFile() {
        return type + "\u2022" + super.status + "\u2022" + super.description + "\n";
    }

    @Override
    public String toString() {
        return type + super.toString();
    }
}
