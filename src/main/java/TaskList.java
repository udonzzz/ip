import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    void addTask(String description) {
        list.add(new Task(description));
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += Integer.toString(i + 1) + ". " + list.get(i).toString() + "\n";
        }
        return output;
    }
}
