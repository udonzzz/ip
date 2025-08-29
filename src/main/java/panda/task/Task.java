package panda.task;

public abstract class Task {
    protected String description;
    protected String status;

    public Task(String description) {
        this.description = description;
        this.status = "[ ]";
    }

    public Task(String status, String description) {
        this.description = description;
        this.status = status;
    }

    public void changeStatus(String action) {
        if (action.equals("mark")) {
            status = "[X]";
        } else {
            status = "[ ]";
        }
    }

    public abstract String writeToFile();

    @Override
    public String toString() {
        return status + " " + description;
    }
}
