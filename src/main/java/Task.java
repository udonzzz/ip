public class Task {
    protected String description;
    protected String status;

    public Task(String description) {
        this.description = description;
        this.status = "[ ]";
    }

    void changeStatus(String input) {
        if (input.equals("mark")) {
            status = "[X]";
        } else if (input.equals("unmark")) {
            status = "[ ]";
        }
    }

    @Override
    public String toString() {
        return status + " " + description;
    }
}
