public class ToDo extends Task {
    protected String type;

    public ToDo(String description) {
        super(description);
        this.type = "[T]";
    }

    @Override
    public String toString() {
        return type + status + " " + description;
    }
}
