package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HistoryController {

    public void gotoMain(ActionEvent event) throws IOException {
        PageLoader.load(event, PageLoader.page_select.MENU);
    }
}
