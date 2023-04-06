import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root= FXMLLoader.load(getClass().getResource("com/example/grrrpisu/main.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("GrrPisU");
        Image icon=new Image("com/example/grrrpisu/Cat_images/lloadingBarFace.psd");
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
