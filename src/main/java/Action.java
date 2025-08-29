public abstract class Action {
    abstract public void execute(TaskList tasks, PandaUi ui, FileManager fileManager) throws PandaException;

    abstract public boolean isExit();
}