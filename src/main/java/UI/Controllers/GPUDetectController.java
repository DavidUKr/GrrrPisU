package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import data.GPUDetector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GPUDetectController implements Initializable, IController{
    @FXML
    Button btnDetectGPU;
    @FXML
    Button btnBACK;
    @FXML
    Label lblGPUName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblGPUName.setText(GPUDetector.getGPU());
        lblGPUName.setAlignment(Pos.CENTER);

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