package Scenes;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class SceneLoading extends Scene {
    public static Scene create() {
        return new SceneLoading(createGroup());
    }

    private SceneLoading(Parent root) { super(root); }

    private static Group createGroup() {
        ProgressIndicator prog = new ProgressIndicator();
        prog.setTranslateX(225);
        prog.setTranslateY(210);

        Label charg = new Label("Chargement du contenu");
        charg.setTranslateX(185);
        charg.setTranslateY(280);

        return new Group(prog, charg);
    }
}
