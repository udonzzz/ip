import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileWriter;

public class FileManager {
    private final String pathName;
    private final Path path;

    public FileManager(String pathName) {
        this.pathName = pathName;
        path = Paths.get(pathName);
    }

    public void loadTasks(TaskList tasks, PandaUi ui) {
        try {
            if (Files.exists(path)) {
                Scanner fileScanner = new Scanner(path);
                while (fileScanner.hasNextLine()) {
                    String[] taskInfo = fileScanner.nextLine().split("\u2022");
                    switch (taskInfo[1]) {
                    case "[X]":
                        break;
                    case "[ ]":
                        break;
                    default:
                        throw new IOException();
                    }
                    switch (taskInfo[0]) {
                    case "[T]":
                        tasks.addTask(new ToDo(taskInfo[1], taskInfo[2]));
                        break;
                    case "[D]":
                        tasks.addTask(new Deadline(taskInfo[1], taskInfo[2], taskInfo[3]));
                        break;
                    case "[E]":
                        tasks.addTask(new Event(taskInfo[1], taskInfo[2], taskInfo[3], taskInfo[4]));
                        break;
                    default:
                        throw new IOException();
                    }
                }
                fileScanner.close();
            }
        } catch (IOException e) {
            ui.loadError();
        }
    }

    public void saveTasks(TaskList tasks, PandaUi ui) {
        try {
            FileWriter fileWriter = new FileWriter(pathName);
            fileWriter.write(tasks.generateListData());
            fileWriter.close();
        } catch (IOException e) {
            ui.saveError();
        }

    }
}
