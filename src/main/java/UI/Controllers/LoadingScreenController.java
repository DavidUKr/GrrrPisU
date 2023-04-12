package UI.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadingScreenController implements Initializable {

    @FXML
    private ProgressBar loadingBar;

    private double progress=0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadingBar.setStyle("-fx-accent: green;");
    }

    public void increaseProg(){
        if(progress<1){
            progress+=0.1;
            loadingBar.setProgress(progress);
        }
    }
}
