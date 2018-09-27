package Main;

import Scenes.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage = new Stage();

    public static void main(String[] args) { launch(args); }

    public void start(Stage mainStage) {
        mainStage = stage;
        Scene sceneConnexion = SceneConnexion.create();

        stage.setTitle("Laboratoire 5");
        stage.setResizable(false);
        stage.setHeight(550);
        stage.setWidth(520);
        stage.setScene(sceneConnexion);
        stage.show();
    }
}
