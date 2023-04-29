package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GPUDetectController implements Initializable, IController{
    @FXML
    Button btnDetectGPU;
    @FXML
    Button btnBACK;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnBACK.setOnAction(event -> {

            if(PageLoader.getInSettings()) {
                try {
                    PageLoader.load(event, page_select.SETTINGS);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    PageLoader.load(event, page_select.INITIAL_SETUP);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            });
    }


}