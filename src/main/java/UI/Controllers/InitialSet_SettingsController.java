package UI.Controllers;

import UI.SceneLoaders.GPUDetectLoader;
import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;


public class InitialSet_SettingsController {
    //FXML injections
    @FXML
    public ImageView imgToMAIN;
    @FXML
    private ImageView imgSelBLUE;
    @FXML
    private ImageView imgSelYELLOW;
    @FXML
    private ImageView imgSelEn;
    @FXML
    private ImageView imgSelRo;

    //images for cat and language selection
    Image Blue_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/BlueCat_Selected.png"));
    Image Blue_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/BlueCat_Unselected.png"));
    Image Yel_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/YellowCat_Selected.png"));
    Image Yel_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/YellowCat_Unselected.png"));
    Image EN_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/ENG_Selected.png"));
    Image EN_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/ENG_Unselected.png"));
    Image RO_sel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/RO_Selected.png"));
    Image RO_unsel=new Image(getClass().getResourceAsStream("/UI/images/InitialSetup_Settings/RO_Unselected.png"));

    public void select_Blue(){
        imgSelBLUE.setImage(Blue_sel);
        imgSelYELLOW.setImage(Yel_unsel);
        PageLoader.setThemeb(false);
    }

    public void select_Yellow(){
        imgSelBLUE.setImage(Blue_unsel);
        imgSelYELLOW.setImage(Yel_sel);
        PageLoader.setThemeb(true);
    }

    public void select_EN(){
        imgSelEn.setImage(EN_sel);
        imgSelRo.setImage(RO_unsel);
        PageLoader.setLangb(false);
    }

    public void select_RO(){
        imgSelEn.setImage(EN_unsel);
        imgSelRo.setImage(RO_sel);
        PageLoader.setLangb(true);
    }

    public void gotoMain(ActionEvent event) throws IOException {
        PageLoader.load(event, PageLoader.page_select.MENU);
    }

    public void detect_GPU(ActionEvent event) throws IOException {
        GPUDetectLoader.changeScene(event, "/UI/pages/resized/GpuDet.fxml");
    }

    public void goback_GPU(ActionEvent event) throws IOException {
        GPUDetectLoader.changeScene(event, "/UI/pages/resized/Initial_setup.fxml");
    }

}
