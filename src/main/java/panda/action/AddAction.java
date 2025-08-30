package panda.action;

import panda.FileManager;
import panda.PandaException;
import panda.PandaUi;
import panda.TaskList;
import panda.task.Deadline;
import panda.task.Event;
import panda.task.ToDo;

public class AddAction extends Action {
    private final String action;
    private final String[] taskInfo;

    public AddAction(String action, String[] taskInfo) {
        this.action = action;
        this.taskInfo = taskInfo;
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException {
        if (action.equals("todo")) {
            ui.taskAdded(tasks.addTask(new ToDo(taskInfo[0])), tasks);
        } else if (action.equals("deadline")) {
            ui.taskAdded(tasks.addTask(new Deadline(taskInfo[0], taskInfo[1])), tasks);
        } else if (action.equals("event")) {
            ui.taskAdded(tasks.addTask(new Event(taskInfo[0], taskInfo[1], taskInfo[2])), tasks);
        }
        fileManager.saveTasks(tasks, ui);
    }

    public boolean isExit() {
        return false;
    }
}
