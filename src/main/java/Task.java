public class Task {
    protected String description;
    protected String status;

    public Task(String description) {
        this.description = description;
        this.status = "[ ]";
    }

    void changeStatus() {
        if (status.equals("[ ]")) {
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
