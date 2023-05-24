package main_pack;

import UI.Controllers.LoadingScreenController;
import benchmark.OpenGL.Generator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Generator generator;

    @Override
    public void start(Stage stage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("/UI/pages/ENG/Initial_Setup.fxml"));
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

    public static void loadRender(LoadingScreenController loadingController) throws IOException {
        generator=new Generator(loadingController);
    }

    public static Generator getGenerator() {
        return generator;
    }
}