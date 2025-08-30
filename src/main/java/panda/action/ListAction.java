package panda.action;

import panda.TaskList;
import panda.PandaUi;
import panda.FileManager;

public class ListAction extends Action {
    public ListAction() {
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) {
        ui.list(tasks);
    }

    public boolean isExit() {
        return false;
    }
}
