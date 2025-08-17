import java.util.ArrayList;

public class TaskList {
    private ArrayList<String> list;

    public TaskList() {
        this.list = new ArrayList<String>();
    }
    
    void addTask(String task) {
        list.add(task);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += Integer.toString(i + 1) + list.get(i) + "\n";
        }
        return output;
    }
}
