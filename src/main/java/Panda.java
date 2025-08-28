import java.io.IOException;
import java.io.FileWriter;
import java.time.format.DateTimeParseException;

public class Panda {

    private static boolean arraySizeWrong(String[] array, int expectedSize) {
        return  array.length != expectedSize;
    }

    public static void main(String[] args) throws IOException{
        String pathName = "panda.txt";
        PandaUi ui = new PandaUi();
        FileManager fileManager = new FileManager(pathName);
        TaskList tasks = new TaskList();
        fileManager.loadTasks(tasks, ui);
        ui.greet();
        while (true) {
            try {
                String input = ui.userInput();
                String[] strArray = input.split(" ", 2);
                String action = strArray[0];
                if (action.equals("bye")) {
                    ui.bye();
                    break;
                }
                if (action.equals("list")) {
                    ui.reply(tasks);
                    continue;
                }
                if (arraySizeWrong(strArray, 2)) {
                    throw new PandaException(action, "");
                }
                if (action.equals("mark")) {
                    Task task = tasks.changeStatus(strArray[1], action);
                    ui.taskMarked(task);
                    continue;
                }
                if (action.equals("unmark")) {
                    Task task = tasks.changeStatus(strArray[1], action);
                    ui.taskUnmarked(task);
                    continue;
                }
                if (action.equals("delete")) {
                    Task task = tasks.deleteTask(strArray[1]);
                    ui.taskDeleted(task, tasks);
                    continue;
                }
                if (action.equals("todo")) {
                    Task todo = tasks.addTask(new ToDo(strArray[1]));
                    ui.taskAdded(todo, tasks);
                    continue;
                }
                if (action.equals("deadline")) {
                    String[] infoDeadline = strArray[1].split(" /by ");
                    if (arraySizeWrong(infoDeadline, 2)) {
                        throw new PandaException(action, infoDeadline[0]);
                    }
                    Task deadline = tasks.addTask(new Deadline(infoDeadline[0], infoDeadline[1]));
                    ui.taskAdded(deadline, tasks);
                    continue;
                }
                if (action.equals("event")) {
                    String[] infoEvent = strArray[1].split(" /from | /to ");
                    if (arraySizeWrong(infoEvent, 3)) {
                        throw new PandaException(action, infoEvent[0]);
                    }
                    Task event = tasks.addTask(new Event(infoEvent[0], infoEvent[1], infoEvent[2]));
                    ui.taskAdded(event, tasks);
                    continue;
                }
                throw new PandaException(action, "");
            } catch (PandaException e) {
                ui.pandaError(e);
            } catch (DateTimeParseException e) {
                ui.wrongDateFormat();
            }
        }
        fileManager.saveTasks(tasks);
    }
}