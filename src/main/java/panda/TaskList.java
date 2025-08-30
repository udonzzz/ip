package panda;

import panda.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
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

    /**
     * Returns String which contains tasks from the list containing the keyword.
     *
     * @param keyword Keyword provided by user.
     * @return String of tasks that contain the keyword.
     */
    public String generateListWithKeywords(String keyword) {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).hasKeyword(keyword)) {
                output += "\n" + (i + 1) + "." + list.get(i).toString();
            }
        }
        if (output == "") {
            return "There are no matching tasks in your list";
        } else {
            return output;
        }
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return "List is empty";
        }
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += "\n" + Integer.toString(i + 1) + "." + list.get(i).toString();
        }
        return output;
    }
}
