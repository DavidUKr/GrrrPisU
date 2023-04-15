package UI.Controllers;

import UI.SceneLoaders.HelpLoader;
import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.PopUpLoader;
import javafx.event.ActionEvent;
import javafx.stage.Popup;
import java.io.IOException;


public class MainMenuController {

    public void gotoSettings(ActionEvent event) throws IOException {
        PopUpLoader.getPopup().hide();
        PageLoader.load(event, PageLoader.page_select.SETTINGS);
    }
    public void gotoHistory(ActionEvent event) throws IOException {

        PopUpLoader.getPopup().hide();

        PageLoader.load(event, PageLoader.page_select.HISTORY);
    }
    public void startTest(){

        PopUpLoader.getPopup().hide();

        System.out.println("STARTING TEST");
    }

    public void openCatFight(){
        PopUpLoader.getPopup().hide();
        System.out.println("Opening Cat fght pop-up");
    }

    public void openHelp(ActionEvent event) throws IOException, InterruptedException {
        //HelpLoader.changeScene(event, "/UI/pages/help.fxml");

        PopUpLoader.loadHelp(event);
    }
}