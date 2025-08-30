package panda.action;

import panda.FileManager;
import panda.PandaException;
import panda.PandaUi;
import panda.TaskList;

public abstract class Action {
    public abstract void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException;

    public abstract boolean isExit();
}
