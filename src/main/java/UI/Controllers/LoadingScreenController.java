package UI.Controllers;

import UI.SceneLoaders.PageLoader;
import UI.SceneLoaders.page_select;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class LoadingScreenController implements Initializable,IController{

    private boolean doneRendering;

    @FXML
    Label lblAdvice;

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

        initIterator();

        if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
        else System.out.println("Loading bar images null");
    }

    public void increaseProg() throws IOException {

        if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
        else {
            //System.out.println("Loading finished");
            //PageLoader.load(event, page_select.SCORE);
            initIterator();
        }
    }

    public void increaseProg(ActionEvent event) throws IOException {
        if(doneRendering)PageLoader.load(event, page_select.SCORE);
        else lblAdvice.setText("Not yet");
    }

    public void increaseProg(int steps) throws IOException {

        for (int i=0; i<steps;i++) {
            if(imIt.hasNext()) imgBar_Cat.setImage(imIt.next());
            else {
                System.out.println("Loading finished");
                //PageLoader.load(PageLoader.getLastEvent(), page_select.MENU);
                break;
            }
        }

    }

    private void initIterator(){

        if(PageLoader.getTHEME_b()) {
            imIt=YELLOW.iterator();
        }
        else {
            imIt=BLUE.iterator();
        }
    }

    /*public void toScore() throws IOException {
        PageLoader.load(PageLoader.getLastEvent(), page_select.SCORE);
    }*/

    public LoadingScreenController getController(){
        return this;
    }


    public void setDoneRendering(boolean doneRendering) {
        this.doneRendering = doneRendering;
    }

    public void setLblAdvice(String text){
        lblAdvice.setText(text);
    }
}
