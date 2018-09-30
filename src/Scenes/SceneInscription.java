package Scenes;

import Main.Main;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class SceneInscription extends Scene {
    private static TextField[] entrees = new TextField[3];
    private static PasswordField[] passwords = new PasswordField[2];

    private static ToggleGroup groupeBoutons;
    private static Spinner spinAge;
    private static CheckBox conditions;

    private static String[] donnees = new String[6];
    private static boolean[] valide = new boolean[6];

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

        Label genre = new Label("Genre");
        genre.setTranslateX(175);
        genre.setTranslateY(285);

        Label age = new Label("Âge");
        age.setTranslateX(175);
        age.setTranslateY(340);

        setEntrees();

        return new Group(entrees[0], entrees[1], entrees[2], passwords[0], passwords[1], prenom, nom, username, password, confirmPassword, genre, age, createAutres(), createBoutons());
    }

    private static void setEntrees() {
        int y = 30;

        for (int i = 0; i < 3; i++) { entrees[i] = new TextField(); }
        for (int i = 0; i < 2; i++) { passwords[i] = new PasswordField(); }

        for (int i = 0; i < 3; i++) {
            entrees[i].setTranslateX(175);
            entrees[i].setTranslateY(y);
            y += 55;
        }

        entrees[0].setPromptText("Prénom");
        entrees[0].textProperty().addListener((that, ov, nv) -> valide[0] = nv.isEmpty());

        entrees[1].setPromptText("Nom de famille");
        entrees[2].setPromptText("Nom d'utilisateur");

        for (int i = 0; i < 2; i++) {
            passwords[i].setTranslateX(175);
            passwords[i].setTranslateY(y);
            passwords[i].setPromptText("Mot de passe");
            y += 55;
        }
    }

    private static Group createAutres() {
        groupeBoutons = new ToggleGroup();

        RadioButton h = new RadioButton("Homme");
        h.setTranslateX(175);
        h.setTranslateY(305);
        h.setToggleGroup(groupeBoutons);

        RadioButton f = new RadioButton("Femme");
        f.setTranslateX(245);
        f.setTranslateY(305);
        f.setToggleGroup(groupeBoutons);

        RadioButton a = new RadioButton("Autre");
        a.setTranslateX(310);
        a.setTranslateY(305);
        a.setToggleGroup(groupeBoutons);

        spinAge = new Spinner(18, 150, 18);
        spinAge.setTranslateX(175);
        spinAge.setTranslateY(360);

        conditions = new CheckBox("J'accepte les conditions d'utilisation");
        conditions.setTranslateX(175);
        conditions.setTranslateY(400);

        return new Group(h, f, a, spinAge, conditions);
    }

    private static Group createBoutons() {
        Button inscription = new Button("S'inscrire");
        inscription.setTranslateX(175);
        inscription.setTranslateY(435);
        inscription.setOnAction(event -> inscription());

        Button effacer = new Button("Effacer");
        effacer.setTranslateX(241);
        effacer.setTranslateY(435);
        effacer.setOnAction(event -> reset());

        Button retour = new Button("Retour");
        retour.setTranslateX(296);
        retour.setTranslateY(435);
        retour.setOnAction(event -> Main.setScene(SceneConnexion.create()));

        return new Group(inscription, effacer, retour);
    }

    private static void reset() {
        for (TextField entree : entrees) { entree.setText(null); }
        for (PasswordField password : passwords) { password.setText(null); }
        groupeBoutons.selectToggle(null);
        spinAge.getValueFactory().setValue(18);
        conditions.setSelected(false);
    }

    private static void inscription() {

    }
}
