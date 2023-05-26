package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.PopUpLoader;
import UI.SceneLoaders.page_select;
import javafx.event.ActionEvent;
import main_pack.Main;
import java.io.IOException;


public class MainMenuController implements IController{

    public void gotoSettings(ActionEvent event) throws IOException {
        closePopups();
        PageLoader.load(event, page_select.SETTINGS);
    }
    public void gotoHistory(ActionEvent event) throws IOException {
        closePopups();
        PageLoader.load(event, page_select.LOCAL_HIST);
    }
    public void startTest(ActionEvent event) throws IOException, InterruptedException {
        closePopups();
        PageLoader.load(event,page_select.CHOOSE_TEST);
        /**PageLoader.load(event, page_select.LOADING);
        Main.loadRender((LoadingScreenController) PageLoader.getController());*/

    }

    public void openCatFight(ActionEvent event) throws InterruptedException, IOException {
        System.out.println("Opening Cat fight pop-up");
        PopUpLoader.catFight(event);
        closePopups();
     }

    public void openHelp(ActionEvent event) throws IOException, InterruptedException {
        PopUpLoader.loadHelp(event);
    }

    private void closePopups(){

        try {
            PopUpLoader.getPopup().hide();
        } catch (Exception e){}
    }

}