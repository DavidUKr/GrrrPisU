package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class InitialSetupCntroller {

    @FXML
    private ImageView imgSelBLUE;
    private ImageView imgSelYELLOW;
    private ImageView imgSelEn;
    private ImageView imgSelRo;

    Image Blue_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/BlueCat_Selected.png"));
    Image Blue_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/BlueCat_Unselected.png"));
    Image Yel_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/YellowCat_Selected.png"));
    Image Yel_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/YellowCat_Unselected.png"));
    Image EN_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/ENG_Selected.png"));
    Image EN_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/ENG_Unselected.png"));
    Image RO_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/RO_Selected.png"));
    Image RO_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/RO_Unselected.png"));

    Stage stage;
    Scene scene;
    Parent root;

    public void select_Blue(){
        imgSelBLUE.setImage(Blue_sel);
        imgSelYELLOW.setImage(Yel_unsel);
    }

    public void select_Yellow(){
        imgSelBLUE.setImage(Blue_unsel);
        imgSelYELLOW.setImage(Yel_sel);
    }


    public void select_EN(){
        imgSelEn.setImage(EN_sel);
        imgSelRo.setImage(RO_unsel);
    }

    public void select_RO(){
        imgSelEn.setImage(EN_unsel);
        imgSelRo.setImage(RO_sel);
    }

    public void begin_gotoMain(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("project.UI/pages/main.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void detect_GPU(ActionEvent event) throws IOException {

    }
}
