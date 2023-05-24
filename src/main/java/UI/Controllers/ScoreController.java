package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.PopUpLoader;
import UI.SceneLoaders.page_select;
import benchmark.OpenGL.Generator;
import database.DBUtils_local;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class  ScoreController implements Initializable {

    @FXML
    private GridPane g_information;
    @FXML
    private Label l_name;

    @FXML
    private Label l_input;

    @FXML
    private Label l_color;
    public Generator generator;
    @FXML
    private Label l_score;

    @FXML
    private Button b_hist;

    @FXML
    private Button b_menu;

    @FXML
    private Button b_cat_fight;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils_local.score(null, l_name.getText(), Integer.parseInt(l_input.getText()), l_color.getText(), Float.parseFloat(l_score.getText()));


        /**public void setValueInGridPane() {
             l_score = new Label(String.valueOf(value)); // Create a label with the value

            // Set the position of the label in the GridPane
            GridPane.setRowIndex(label, row);
            GridPane.setColumnIndex(label, column);

            // Add the label to the GridPane
            g_information.getChildren().add(l_score);
        }*/

        b_hist.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    PageLoader.load(event, page_select.LOCAL_HIST);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b_menu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    PageLoader.load(event, page_select.MENU);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        b_cat_fight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    PopUpLoader.catFight(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}