package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.PopUpLoader;
import javafx.event.ActionEvent;
import javafx.stage.Popup;
import java.io.IOException;


public class MainMenuController {

    public void gotoSettings(ActionEvent event) throws IOException {
        closePopups();
        PageLoader.load(event, PageLoader.page_select.SETTINGS);
    }
    public void gotoHistory(ActionEvent event) throws IOException {
        closePopups();
        PageLoader.load(event, PageLoader.page_select.HISTORY);
    }
    public void startTest(ActionEvent event) throws IOException {
        closePopups();
        System.out.println("STARTING TEST");
        PageLoader.load(event, PageLoader.page_select.LOADING);
    }

    public void openCatFight(ActionEvent event) throws InterruptedException, IOException {
        System.out.println("Opening Cat fight pop-up");
        PopUpLoader.catFight(event);
        //closePopups();
     }

    public void openHelp(ActionEvent event) throws IOException, InterruptedException {
        //HelpLoader.changeScene(event, "/UI/pages/help.fxml");

        PopUpLoader.loadHelp(event);
    }

    private void closePopups(){

        try {
            PopUpLoader.getPopup().hide();
        } catch (Exception e){}
    }
}