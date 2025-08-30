package panda;

import java.util.ArrayList;

import panda.task.Task;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public Task addTask(Task task) {
        list.add(task);
        return task;
    }

    public Task changeStatus(String number, String action) throws PandaException {
        try {
            Task task = list.get(index(number));
            task.changeStatus(action);
            return task;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new PandaException(action, "");
        }
    }

    public Task deleteTask(String number) throws PandaException {
        try {
            Task task = list.get(index(number));
            list.remove(task);
            return task;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new PandaException("delete", "");
        }
    }

    private int index(String number) {
        return Integer.parseInt(number) - 1;
    }

    int size() {
        return list.size();
    }

    public String generateListData() {
        String output = "";
        for (Task task : list) {
            output += task.writeToFile();
        }
        return output;
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return "List is empty";
        }
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += (i + 1) + "." + list.get(i).toString();
            if (i != list.size() - 1) {
                output += "\n";
            }
        }
        return output;
    }
}
