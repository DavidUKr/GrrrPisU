package UI.SceneLoaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javafx.util.Duration;

public class PopUpLoader {

    private static Stage stage;
    private static Popup popup;

    private static final Object lock=new Object();

    public static void loadHelp(ActionEvent event) throws InterruptedException {

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        popup=new Popup();
        ImageView info=new ImageView("/UI/images/Help/PopUp_Help(ENG).png");
        info.setFitHeight(300);
        info.setFitWidth(450);
        info.setX(700);
        popup.getContent().add(info);
        popup.show(stage);
        hide_after(10, popup);
    }

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
