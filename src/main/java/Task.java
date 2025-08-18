public class Task {
    protected String description;
    protected String status;

    public Task(String description) {
        this.description = description;
        this.status = "[ ]";
    }

    void changeStatus(String action) {
        if (action.equals("mark")) {
            status = "[X]";
        } else {
            status = "[ ]";
        }
    }

    @Override
    public String toString() {
        return status + " " + description;
    }
}
