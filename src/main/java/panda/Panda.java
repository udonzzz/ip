package panda;

import panda.action.Action;

/**
 * Panda is the entry point for the application for running on the text-based UI.
 * <p>
 * It receives input from the user to add tasks to be done, such as ToDo, Deadline and Event.
 * These tasks can be marked as done/not done or deleted, and they are stored into the text file,
 * such that they are loaded into the program when program starts again the next time.
 */
public class Panda {
    private final PandaUi ui;
    private final FileManager fileManager;
    private final InputParser parser;
    private final TaskList tasks;

    /**
     * Constructs Panda object with the initialised PandaUi, FileManager,
     * InputParser and TaskList objects.
     *
     * @param filePath File path to the text file where tasks are loaded and saved.
     */
    public Panda(String filePath) {
        ui = new PandaUi();
        fileManager = new FileManager(filePath);
        parser = new InputParser();
        tasks = new TaskList();
        fileManager.loadTasks(tasks, ui);
    }

    public String getResponse(String input) {
        try {
            Action a = parser.parseUserInput(input);
            a.execute(tasks, ui, fileManager);
        } catch (PandaException e) {
            ui.showPandaError(e);
        }
        return ui.provideResponse();
    }

    /**
     * Runs the application on console until user provides the input to exit application.
     */
    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserInput();
                Action a = parser.parseUserInput(input);
                a.execute(tasks, ui, fileManager);
                isExit = a.isExit();
            } catch (PandaException e) {
                ui.showPandaError(e);
            }
        }
    }

    public static void main(String[] args) {
        new Panda("data/panda.txt").run();
    }
}
