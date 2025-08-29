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
