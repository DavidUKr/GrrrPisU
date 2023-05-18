package benchmark.OpenGL;

import UI.Controllers.LoadingScreenController;

import java.io.IOException;

public class Generator implements Runnable{

    private RenderFrame renderFrame;
    private JOGL jogl;
    private Thread genThread;
    private boolean running;
    LoadingScreenController loadingScreenController;
    public Generator(LoadingScreenController loadingController) throws IOException {
        loadingScreenController=loadingController;
        renderFrame = new RenderFrame();
        loadingScreenController.increaseProg(5);
        jogl = new JOGL();
        jogl.renderGL(renderFrame);
        loadingScreenController.increaseProg(6);
        start();
    }

    public void start(){
        genThread=new Thread(this);
        running=true;
        genThread.start();
    }

    public void stop(){
        running=false;
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0/ 200; //1sec=1 billion (10^9) nanosecods
        long lastFrame= System.nanoTime();
        long now= System.nanoTime();

        int frames=0;
        long lastCheck=System.currentTimeMillis();

        while(running){

            now=System.nanoTime();

            if(now - lastFrame>=timePerFrame){

                jogl.getGlCanvas().repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck>=1000){
                lastCheck=System.currentTimeMillis();
                System.out.println("FPS: "+frames);
                frames=0;
            }
        }
    }
}
