package panda.action;

import panda.TaskList;
import panda.PandaUi;
import panda.FileManager;
import panda.PandaException;

/**
 * Action is the superclass for AddAction, DeleteAction, ExitAction,
 * ListAction and MarkAction.
 */
public abstract class Action {
    abstract public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException;

    abstract public boolean isExit();
}