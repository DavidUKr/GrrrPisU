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


public class GPUDetect implements Initializable {
    @FXML
    Button btnDetectGPU;
    @FXML
    Button backbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDetectGPU.setOnAction(event -> {
            GPUDetectLoader.changeScene(event, "/UI/pages/GpuDet.fxml");
        });

        backbtn.setOnAction(event -> {
            GPUDetectLoader.changeScene(event, "/UI/pages/Initial_setup.fxml");
        });
    }


}