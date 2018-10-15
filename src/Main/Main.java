package Main;

import Scenes.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main extends Application {
    private static Stage stage = new Stage();
    public static Data data = new Data();

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
        stage.setOnHiding(event -> data.saveData());
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public static String hash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

        return sha256;
    }
}
