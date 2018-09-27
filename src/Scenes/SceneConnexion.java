package Scenes;

import Main.*;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SceneConnexion extends Scene{
    static TextField textUsername = new TextField();
    static PasswordField textPassword = new PasswordField();

    public static Scene create() {
        return new SceneConnexion(createGroup());
    }

    private SceneConnexion(Parent root) {
        super(root);
    }

    private static Group createGroup() {
        Label username = new Label("Nom d'utilisateur");
        username.setTranslateX(175);
        username.setTranslateY(180);

        Label password = new Label("Mot de passe");
        password.setTranslateX(175);
        password.setTranslateY(235);

        textUsername.setPromptText("Nom d'utilisateur");
        textUsername.setTranslateX(175);
        textUsername.setTranslateY(200);

        textPassword.setPromptText("Mot de passe");
        textPassword.setTranslateX(175);
        textPassword.setTranslateY(255);

        return new Group(username, password, textUsername, textPassword, createBoutons());
    }

    private static Group createBoutons() {
        Button connexion = new Button("Se connecter");
        connexion.setTranslateX(175);
        connexion.setTranslateY(295);
        connexion.setOnAction(event -> {

        });

        Button inscription = new Button("S'inscrire");
        inscription.setTranslateX(262);
        inscription.setTranslateY(295);
        inscription.setOnAction(event -> {
            Main.stage.setScene(SceneInscription.create());
        });

        return new Group(connexion, inscription);
    }
}
