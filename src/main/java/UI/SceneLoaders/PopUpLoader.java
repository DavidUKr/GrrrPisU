package UI.SceneLoaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javafx.util.Duration;

import java.io.IOException;


public class PopUpLoader {

    private static Stage stage;
    private static Popup popup;
    private static ImageView info;

    private static final Object lock=new Object();

    public static void loadHelp(ActionEvent event) throws InterruptedException {

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        popup=new Popup();

        if(PageLoader.getLANG_b()) info=new ImageView("/UI/images/Help/_New_PopUp_Help(RO).png");
        else info=new ImageView("/UI/images/Help/PopUp_Help(ENG).png");

        info.setFitHeight(300);
        info.setFitWidth(450);
        info.setX(700);

        popup.getContent().add(info);
        popup.show(stage);
        hide_after(10, popup);
    }

    public static void catFight(ActionEvent event) throws IOException {

        FXMLLoader loader;
        if (PageLoader.getLANG_b()) {
            loader = new FXMLLoader(PopUpLoader.class.getResource("/UI/pages/RO/CatFight_ro.fxml"));
        } else {
            loader = new FXMLLoader(PopUpLoader.class.getResource("/UI/pages/ENG/CatFight_eng.fxml"));
        }
        Parent root = loader.load();

        // Create a new stage
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);

        //add icon
        Image icon=new Image("/UI/images/Logo_fundal_alb.png");
        popupStage.getIcons().add(icon);

        // Set the scene on the stage
        Scene scene = new Scene(root);
        popupStage.setScene(scene);

        // Show the stage as a modal dialog
        popupStage.showAndWait();
    }


        /**stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        popup=new Popup();

        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(PopUpLoader.class.getResource("/UI/pages/ENG/CatFight_ro.fxml"));
        Node fxml= loader.load();


        popup.getContent().add(fxml);
        popup.show(stage);
        hide_after(10, popup);

    }*/
    public static Popup getPopup(){
        return popup;
    }

    private static void hide_after(int timeout, Popup pop) {
        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(timeout), event->{
            pop.hide();
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
