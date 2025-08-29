package panda.action;

import panda.TaskList;
import panda.PandaUi;
import panda.FileManager;
import panda.PandaException;

public class DeleteAction extends Action {
    private final String number;
    public DeleteAction(String number) {
        this.number = number;
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException {
        ui.taskDeleted(tasks.deleteTask(number), tasks);
        fileManager.saveTasks(tasks, ui);
    }

    public boolean isExit() {
        return false;
    }
}
