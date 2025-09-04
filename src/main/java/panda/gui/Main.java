package panda.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import panda.Panda;

/**
 * A GUI for Panda using FXML.
 */
public class Main extends Application {

    private final Panda panda = new Panda("data/panda.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            stage.setTitle("Panda");
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            fxmlLoader.<MainWindow>getController().setPanda(panda); // inject the Panda instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
