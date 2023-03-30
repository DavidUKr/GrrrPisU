import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    Color backgound_color= Color.rgb(209,239,244);

    @Override
    public void start(Stage stage) throws Exception {

        Group root=new Group();
        Scene scene=new Scene(root, backgound_color);

        stage.setScene(scene);
        stage.setTitle("GrrPisU");
        //stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setWidth(1440);
        stage.setHeight(1024);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
