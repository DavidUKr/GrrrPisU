package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HistoryController implements IController{

    public void gotoMain(ActionEvent event) throws IOException {
        PageLoader.load(event, page_select.MENU);
    }
}
