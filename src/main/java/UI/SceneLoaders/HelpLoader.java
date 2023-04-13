package UI.SceneLoaders;

import UI.Controllers.Help;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpLoader {


    public static void changeScene(ActionEvent event, String fxmlFile) {

        Parent root = null;

        try {
            root = FXMLLoader.load(Help.class.getResource(fxmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.setScene(new Scene(root));
        stage.centerOnScreen();

        //stage.initOwner(MainMenuController);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();

    }
}