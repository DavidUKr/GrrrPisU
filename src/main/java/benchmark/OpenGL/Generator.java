package benchmark.OpenGL;

import UI.Controllers.LoadingScreenController;

import java.io.IOException;

public class Generator implements Runnable{

    private RenderFrame renderFrame;
    private RenderPanel renderPanel;

    private Thread genThread;
    LoadingScreenController loadingScreenController;
    public Generator(LoadingScreenController loadingController) throws IOException {
        //loadingScreenController=loadingController;
        renderPanel = new RenderPanel();
        //loadingScreenController.increaseProg(5);
        renderFrame = new RenderFrame(renderPanel);
        //loadingScreenController.increaseProg(6);
        startGenerator();
    }

    public void startGenerator(){
        genThread=new Thread(this);
        genThread.start();
    }
    @Override
    public void run() {


    }
}
