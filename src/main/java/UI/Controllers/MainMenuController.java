package UI.Controllers;

import UI.SceneLoaders.HelpLoader;
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
    public void startTest(){
        closePopups();
        System.out.println("STARTING TEST");
    }

    public void openCatFight(){
        closePopups();
        System.out.println("Opening Cat fight pop-up");
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