import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    void addTask(String description) {
        list.add(new Task(description));
    }

    void changeStatus(String number) {
        list.get(index(number)).changeStatus();
    }

    Task getTask(String number) {
        return list.get(index(number));
    }

    int index(String number) {
        return Integer.parseInt(number) - 1;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += Integer.toString(i + 1) + "." + list.get(i).toString() + "\n";
        }
        return output;
    }
}
