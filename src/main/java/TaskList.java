import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    void addTask(Task task) {
        list.add(task);
    }

    void changeStatus(String number, String action) {
        list.get(index(number)).changeStatus(action);
    }

    Task getTask(String number) {
        return list.get(index(number));
    }

    int index(String number) {
        return Integer.parseInt(number) - 1;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += Integer.toString(i + 1) + "." + list.get(i).toString();
            if (i != list.size() - 1) {
                output += "\n";
            }
        }
        return output;
    }
}
