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

    /**
     * Returns true if keyword is found in description.
     *
     * @param keyword Keyword provided by user.
     * @return true if description contains keyword, false otherwise.
     */
    public boolean hasKeyword(String keyword) {
        if (description.contains(keyword)) {
            return true;
        }
        return false;
    }

    public abstract String writeToFile();

    @Override
    public String toString() {
        return status + " " + description;
    }
}
