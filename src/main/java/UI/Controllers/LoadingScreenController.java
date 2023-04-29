package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LoadingScreenController implements Initializable,IController{

    @FXML
    private ImageView imgBar_Cat;
    private ArrayList<Image> BLUE=new ArrayList<Image>();
    private ArrayList<Image> YELLOW= new ArrayList<Image>();
    private Iterator<Image> imIt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loadingBar.setStyle("-fx-accent: green;");
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_0.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_1.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_2.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_3.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_4.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_5.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_6.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_7.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_8.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_9.png"));
        BLUE.add(new Image("/UI/images/Loading/Blue/LB_End.png"));

        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB1.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB2.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB3.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB4.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB5.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB6.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB7.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB8.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB9.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB10.png"));
        YELLOW.add(new Image("/UI/images/Loading/Yellow/LoadingB11.png"));

        if(PageLoader.getTHEME_b()) {
            imIt=YELLOW.iterator();
        }
        else {
            imIt=BLUE.iterator();
        }

        if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
        else System.out.println("Loading bar images null");
    }

    public void increaseProg(ActionEvent event) throws IOException {

        if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
        else {
            System.out.println("Loading finished");
            PageLoader.load(event, PageLoader.page_select.MENU);
        }
    }

    public void increaseProg(int steps){

        for (int i=0; i<steps;i++) {
            if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
            else {
                System.out.println("Loading finished");
                //start rendering
                break;
            }
        }

    }

    public LoadingScreenController getController(){
        return this;
    }
}
