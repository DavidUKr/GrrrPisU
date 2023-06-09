package main_pack;

import UI.Controllers.LoadingScreenController;
import UI.Controllers.ScoreController;
import benchmark.OpenGL.Generator;
import benchmark.OpenGL.obj;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static double score;

    private static Generator generator;
    private static obj objectS;
    @Override
    public void start(Stage stage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("/UI/pages/ENG/Initial_setup.fxml"));
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/UI/css/InitialSetup/NoTheme_init.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("GrrPisU");
        Image icon=new Image("/UI/images/Logo_fundal_alb.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESC"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void loadRender(LoadingScreenController loadingController, obj object) throws IOException, InterruptedException {
        objectS=object;
        generator=new Generator(loadingController, object);
    }

    public static Generator getGenerator() {
        return generator;
    }

    public static double getScore() {
        return score;
    }

    public static void setScore(double score) {
        Main.score = score;
    }

    public static obj getObjectS() {
        return objectS;
    }
}