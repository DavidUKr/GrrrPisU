package benchmark.OpenGL;

import UI.Controllers.LoadingScreenController;

import java.io.IOException;

public class Generator implements Runnable{

    private JOGL jogl;
    private Thread genThread;
    private boolean running;
    private int cycle_count=0;
    private obj object;
    LoadingScreenController loadingScreenController;

    private int FPS=100000;
    public Generator(LoadingScreenController loadingController) throws IOException {
            loadingScreenController=loadingController;
        setObject(obj.TETRAHEDRON);
        jogl = new JOGL();
            loadingScreenController.increaseProg(5);
        jogl.renderGL(object);
        start();
            loadingScreenController.increaseProg(6);
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
        double timePerFrame = 1000000000.0/ FPS; //1sec=1 billion (10^9) nanosecods
        long lastFrame= System.nanoTime();
        long now= System.nanoTime();

        int frames=0;
        long lastCheck=System.currentTimeMillis();

        while(running){

            now=System.nanoTime();

            if(now - lastFrame>=timePerFrame){

                //jogl.getWindow().display();
                jogl.getGlCanvas().repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck>=1000){
                lastCheck=System.currentTimeMillis();
                System.out.println("FPS: "+frames);
                frames=0;
                cycle_count++;
            }

            if (cycle_count==20) {
                stop();
                System.out.println("done rendering");
            }
        }
    }

    public obj getObject() {
        return object;
    }

    public void setObject(obj object) {
        this.object = object;
    }
}
