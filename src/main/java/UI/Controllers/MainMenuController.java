package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;

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

    public void selectBenchmark(){
        System.out.println("Choose Benchmark");
    }
}
