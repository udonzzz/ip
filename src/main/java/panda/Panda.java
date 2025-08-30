package panda;

import panda.action.Action;

public class Panda {
    private PandaUi ui;
    private FileManager fileManager;
    private InputParser parser;
    private TaskList tasks;

    public Panda(String filePath) {
        ui = new PandaUi();
        fileManager = new FileManager(filePath);
        parser = new InputParser();
        tasks = new TaskList();
        fileManager.loadTasks(tasks, ui);
    }

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
                ui.pandaError(e);
            }
        }
    }

    public static void main(String[] args) {
        new Panda("data/panda.txt").run();
    }
}