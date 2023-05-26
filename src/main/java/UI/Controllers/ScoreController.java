package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.PopUpLoader;
import UI.SceneLoaders.page_select;
import benchmark.OpenGL.Generator;
import data.GPUDetector;
import database.DBUtils_local;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main_pack.Main;
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

    @FXML
    private ImageView img_Cat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DBUtils_local.score(null, l_name.getText(), l_input.getText(), l_color.getText(), Float.parseFloat(l_score.getText()));

        l_name.setText(GPUDetector.getGPU());
        setL_input();
        setL_color();
        setScore(Main.getScore());
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

    public void setScore(double score){
        l_score.setText(String.format(String.valueOf(score), "%.2f"));
    }

    public void setL_input(){
        switch(Main.getObjectS()){
            case TETRAHEDRON -> l_input.setText("Tetrahedron");
            case CUBE -> l_input.setText("Cube");
            case D20 -> l_input.setText("D&D 20 face dice");
            case SPHERE -> l_input.setText("Sphere");
        }
    }

    public void setL_color(){
        if(PageLoader.getTHEME_b()) {
            l_color.setText("Yellow");
            img_Cat.setImage(new Image("/UI/images/CatFight/CatYellow.png"));
        }
        else {
            l_color.setText("Blue");
            img_Cat.setImage(new Image("/UI/images/CatFight/CatBlue.png"));
        }
    }
}