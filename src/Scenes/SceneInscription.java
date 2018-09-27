package Scenes;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SceneInscription extends Scene {
    private static TextField[] entrees = new TextField[3];
    private static PasswordField[] passwords = new PasswordField[2];

    public static Scene create() {
        return new SceneInscription(createGroup());
    }

    private SceneInscription(Parent root) {
        super(root);
    }

    private static Group createGroup() {
        Label prenom = new Label("Prénom");
        prenom.setTranslateX(175);
        prenom.setTranslateY(10);

        Label nom = new Label("Nom de famille");
        nom.setTranslateX(175);
        nom.setTranslateY(65);

        Label username = new Label("Nom d'utilisateur");
        username.setTranslateX(175);
        username.setTranslateY(120);

        Label password = new Label("Mot de passe");
        password.setTranslateX(175);
        password.setTranslateY(175);

        Label confirmPassword = new Label("Confirmer le mot de passe");
        confirmPassword.setTranslateX(175);
        confirmPassword.setTranslateY(230);

        setEntrees();

        return new Group(entrees[0], entrees[1], entrees[2], passwords[0], passwords[1], prenom, nom, username, password, confirmPassword);
    }

    private static void setEntrees() {
        int y = 30;

        for (int i = 0; i < 3; i++) { entrees[i] = new TextField(); }
        for (int i = 0; i < 2; i++) { passwords[i] = new PasswordField(); }

        for (int i = 0; i < 3; i++) {
            entrees[i].setTranslateX(175);
            entrees[i].setTranslateY(y);
            switch (i) {
                case 0: entrees[i].setPromptText("Prénom"); break;
                case 1: entrees[i].setPromptText("Nom de famille"); break;
                case 2: entrees[i].setPromptText("Nom d'utilisateur"); break;
            }
            y += 55;
        }

        for (int i = 0; i < 2; i++) {
            passwords[i].setTranslateX(175);
            passwords[i].setTranslateY(y);
            passwords[i].setPromptText("Mot de passe");

            y += 55;
        }
    }
}
