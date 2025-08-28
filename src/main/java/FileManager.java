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

    public void loadTasks(TaskList tasks, PandaUi ui) throws IOException {
        if (Files.exists(path)) {
            Scanner fileScanner = new Scanner(path);
            try {
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
            } catch (IOException e) {
                ui.ioError();
                if (ui.userInput().equals("1")) {
                    System.exit(1);
                } else {
                    Files.delete(path);
                }
            }
            fileScanner.close();
        }
    }

    public void saveTasks(TaskList tasks) throws IOException {
        FileWriter fileWriter = new FileWriter(pathName);
        fileWriter.write(tasks.generateListData());
        fileWriter.close();

    }
}
