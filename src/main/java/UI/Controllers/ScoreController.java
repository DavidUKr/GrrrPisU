package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    @FXML
    private Label l_name;

    @FXML
    private Label l_input;

    @FXML
    private Label l_color;

    @FXML
    private Label l_score;

    @FXML
    private Button b_local_hist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils_local.score(null, l_name.getText(), Integer.parseInt(l_input.getText()), l_color.getText(), Float.parseFloat(l_score.getText()));

        b_local_hist.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    PageLoader.load(event, PageLoader.page_select.LOCAL_HIST);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}