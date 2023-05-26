package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import benchmark.OpenGL.obj;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main_pack.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseTestController implements Initializable, IController{

    @FXML
    private Button tetrahedron;

    @FXML
    private Button cube;

    @FXML
    private Button D20;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tetrahedron.setOnAction(event ->{

            try {
                PageLoader.load(event, page_select.LOADING);
                Main.loadRender((LoadingScreenController) PageLoader.getController(), obj.TETRAHEDRON);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        cube.setOnAction(event ->{

            try {
                PageLoader.load(event, page_select.LOADING);
                Main.loadRender((LoadingScreenController) PageLoader.getController(), obj.CUBE);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        D20.setOnAction(event ->{

            try {
                PageLoader.load(event, page_select.LOADING);
                Main.loadRender((LoadingScreenController) PageLoader.getController(), obj.D20);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
