package panda.action;

import panda.TaskList;
import panda.PandaUi;
import panda.FileManager;
import panda.PandaException;

public abstract class Action {
    abstract public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException;

    abstract public boolean isExit();
}