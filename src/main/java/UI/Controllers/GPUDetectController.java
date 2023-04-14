package UI.Controllers;

import UI.SceneLoaders.GPUDetectLoader;
import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GPUDetectController implements Initializable {
    @FXML
    Button btnDetectGPU;
    @FXML
    Button btnBACK;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*btnDetectGPU.setOnAction(event -> {
            GPUDetectLoader.changeScene(event, "/UI/pages/GpuDet.fxml");
        });*/

        btnBACK.setOnAction(event -> {

            if(PageLoader.getInSettings()) {
                try {
                    PageLoader.load(event, PageLoader.page_select.SETTINGS);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    PageLoader.load(event, PageLoader.page_select.INITIAL_SETUP);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            });
    }


}