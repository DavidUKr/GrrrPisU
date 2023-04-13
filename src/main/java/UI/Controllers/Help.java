package UI.Controllers;

import UI.SceneLoaders.GPUDetectLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Help implements Initializable {
    @FXML
    Button helpBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        helpBtn.setOnAction(event -> {
            GPUDetectLoader.changeScene(event, "/UI/pages/resized/GpuDet.fxml");
        });
    }

}