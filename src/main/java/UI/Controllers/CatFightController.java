package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CatFightController implements Initializable, IController{

    @FXML
    Button btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         btnBack.setOnAction(event -> {
            try {
                PageLoader.load(event, page_select.MENU);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}