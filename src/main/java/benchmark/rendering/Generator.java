package benchmark.rendering;

import UI.Controllers.LoadingScreenController;
import benchmark.rendering.objects.IObject;
import javafx.fxml.FXMLLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Generator implements Runnable{

    RenderFrame renderFrame;
    RenderPanel renderPanel;

    LoadingScreenController loadingScreenController;
    public Generator(){
        //loadingScreenController=new LoadingScreenController();
        renderPanel = new RenderPanel();
        //loadingScreenController.increaseProg(5);
        renderFrame = new RenderFrame(renderPanel);
        //loadingScreenController.increaseProg(5);
        run();
    }
    @Override
    public void run() {

    }
}
