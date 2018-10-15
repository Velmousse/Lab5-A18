package Scenes;

import Main.*;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class SceneConnexion extends Scene{
    private static TextField textUsername = new TextField();
    private static PasswordField textPassword = new PasswordField();

    private static Label erreur = new Label();

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

        erreur.setVisible(false);
        erreur.setText("La connexion a échoué");
        erreur.setTextFill(Color.RED);
        erreur.setTranslateX(175);
        erreur.setTranslateY(340);

        return new Group(username, password, textUsername, textPassword, createBoutons(), erreur);
    }

    private static Group createBoutons() {
        Button connexion = new Button("Se connecter");
        connexion.setTranslateX(175);
        connexion.setTranslateY(295);
        connexion.setOnAction(event -> checkConnection());

        Button inscription = new Button("S'inscrire");
        inscription.setTranslateX(262);
        inscription.setTranslateY(295);
        inscription.setOnAction(event -> Main.setScene(SceneInscription.create()));

        return new Group(connexion, inscription);
    }

    private static void checkConnection() {
        boolean pass = false;
        int pos = 0;

        ArrayList<String> values = Main.data.readValues(true);

        for (int i = 0; i < values.size(); i++) {
            if (textUsername.textProperty().get().equals(values.get(i)))
                pos = i;
        }

        values = Main.data.readValues(false);
        try {
            if (Main.hash(textPassword.textProperty().get()).equals(values.get(pos)))
                pass = true;
        }
        catch (NoSuchAlgorithmException e) {

        }

        if (pass)
            Main.setScene(SceneLoading.create());
        else
            erreur.setVisible(true);

    }
}
