package UI.SceneLoaders;

import UI.Controllers.GPUDetect;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;


public class GPUDetectLoader {

    public static void changeScene(javafx.event.ActionEvent event, String fxmlFile) {

        Parent root = null;

        try{
            root= FXMLLoader.load(GPUDetect.class.getResource(fxmlFile));
        }catch (IOException e){
            e.printStackTrace();
        }

        Screen screen= Screen.getPrimary();
        Rectangle2D bounds=screen.getVisualBounds();
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.setScene(new Scene(root));
        stage.centerOnScreen();
        stage.show();

    }


    /**public void gotoMain(URL location, ResourceBundle resources) {
     backbtn.setOnAction(event -> {
     try {
     PageLoader.load(event, PageLoader.page_select.MENU);
     } catch (IOException e) {
     throw new RuntimeException(e);
     }
     });
     }*/
}