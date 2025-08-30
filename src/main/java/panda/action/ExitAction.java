package panda.action;

import panda.FileManager;
import panda.PandaUi;
import panda.TaskList;

public class ExitAction extends Action {
    public ExitAction() {
    }

    public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) {
        ui.bye();
    }

    public boolean isExit() {
        return true;
    }
}
