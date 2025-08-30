package panda.action;

import panda.FileManager;
import panda.PandaException;
import panda.PandaUi;
import panda.TaskList;

public class MarkAction extends Action {
    private final String number;
    private final String action;

    public MarkAction(String number, String action) {
        this.number = number;
        this.action = action;
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException {
        if (action.equals("mark")) {
            ui.taskMarked(tasks.changeStatus(number, action));
        } else {
            ui.taskUnmarked(tasks.changeStatus(number, action));
        }
        fileManager.saveTasks(tasks, ui);
    }

    public boolean isExit() {
        return false;
    }
}
