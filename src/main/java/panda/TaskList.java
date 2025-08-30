package panda;

import java.util.ArrayList;

import panda.task.Task;

/**
 * TaskList manages the list of tasks and the actions to perform on the list,
 * whether it is to add or delete a task, or change the status of a task.
 */
public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Returns Task object after adding it to the list.
     *
     * @param task Task to be added.
     * @return {@link Task} that was added.
     */
    public Task addTask(Task task) {
        list.add(task);
        return task;
    }

    /**
     * Returns Task object after changing its status.
     *
     * @param number Index of task in list.
     * @param action Unmark or mark.
     * @return {@link Task} which had its status changed.
     * @throws PandaException If String number provided in not an integer or out of array index.
     */
    public Task changeStatus(String number, String action) throws PandaException {
        try {
            Task task = list.get(index(number));
            task.changeStatus(action);
            return task;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new PandaException(action, "");
        }
    }

    /**
     * Returns Task object after it is removed from the list.
     *
     * @param number Index of task in list.
     * @return {@link Task} that was deleted.
     * @throws PandaException If String number provided in not an integer or out of array index.
     */
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

    /**
     * Returns String representation of all the tasks in the list in a format
     * to be saved to text file.
     *
     * @return String of tasks in the lists.
     */
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
