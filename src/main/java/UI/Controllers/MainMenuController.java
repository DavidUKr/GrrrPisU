package UI.Controllers;

import UI.SceneLoaders.HelpLoader;
import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.IOException;


public class MainMenuController {

    public void gotoSettings(ActionEvent event) throws IOException {
        PageLoader.load(event, PageLoader.page_select.SETTINGS);
    }
    public void gotoHistory(ActionEvent event) throws IOException {
        PageLoader.load(event, PageLoader.page_select.HISTORY);
    }
    public void startTest(){
        System.out.println("STARTING TEST");
    }

    public void openCatFight(){
        System.out.println("Opening Cat fght pop-up");
    }

    public void openHelp(ActionEvent event)throws IOException{
        HelpLoader.changeScene(event, "/UI/pages/help.fxml");
    }
}