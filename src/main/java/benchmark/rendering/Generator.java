package benchmark.rendering;

import UI.Controllers.LoadingScreenController;

public class Generator implements Runnable{

    RenderFrame renderFrame;
    RenderPanel renderPanel;

    LoadingScreenController loadingScreenController;
    public Generator(LoadingScreenController loadingController){
        loadingScreenController=loadingController;
        renderPanel = new RenderPanel();
        loadingScreenController.increaseProg(5);
        renderFrame = new RenderFrame(renderPanel);
        loadingScreenController.increaseProg(6);
        run();
    }
    @Override
    public void run() {

    }
}
