package panda.action;

import panda.TaskList;
import panda.PandaUi;
import panda.FileManager;

/**
 * ListAction is a subclass of Action, and handles the action
 * of displaying the list of task to user.
 */
public class ListAction extends Action {
    public ListAction() {
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) {
        ui.reply(tasks);
    }

    public boolean isExit() {
        return false;
    }
}
