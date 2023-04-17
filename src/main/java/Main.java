import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("UI/pages/Initial_Setup.fxml"));
        Scene scene=new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UI/css/InitialSetup/EN_init.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("GrrPisU");
        Image icon=new Image("UI/images/Logo_fundal_alb.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("ESC"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
