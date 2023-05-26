package benchmark.OpenGL;

import UI.Controllers.LoadingScreenController;
import main_pack.Main;

import java.io.IOException;

import static java.lang.String.join;

public class Generator implements Runnable{

    private JOGL jogl;
    private Thread genThread;
    private boolean running;
    private int cycle_count = 0;
    private obj object;

    private EventListener eventL;
    private double FPSMean=0;

    LoadingScreenController loadingScreenController;
    private int FPS=100000;

    public Generator(LoadingScreenController loadingController, obj object) throws IOException, InterruptedException {
        loadingScreenController=loadingController;
        loadingController.setDoneRendering(false);
        jogl = new JOGL();
        //loadingScreenController.increaseProg(5);
        this.object=object;
        jogl.renderGL(object);
        eventL = jogl.getEventListener();
        start();
        //loadingScreenController.increaseProg(6);
    }


    public void start() {
        genThread = new Thread(this);
        running = true;
        genThread.start();
    }

    public void stop() {
        running = false;
    }


    public double getScore(){
        double score=0;
        double FPSMean=getFPSMean();
        double resolution=jogl.getResolutionValue();
        double numitor=FPSMean*resolution;

        long time=eventL.computeMeanRenderingTime();

        if(time!=0)
           score=(FPSMean*resolution)/time*10;
        else
            return -1;
        return score;
    }


    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS; //1sec=1 billion (10^9) nanosecods

        // double timePerFrame = 1000000000.0/ FPS; //1sec=1 billion (10^9) nanosecods

        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

        double frameSum = 0;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while (running) {

            now = System.nanoTime();

            if (now - lastFrame >= timePerFrame) {
                //jogl.getWindow().display();
                jogl.getGlCanvas().repaint();
                lastFrame = now;

                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                frameSum += frames;
                //System.out.println("FPS: "+frames);
                frames = 0;
                try {
                    loadingScreenController.increaseProg();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                cycle_count++;
            }

            if (cycle_count==20) {
                stop();
                loadingScreenController.setDoneRendering(true);
                //loadingScreenController.setLblAdvice("Now:) Wait a bit after pressing");
            }

            FPSMean = frameSum / 20;
            //System.out.println("The mean of fps is " + FPSMean);

        }
        FPSMean=frameSum/20;
        double score=getScore();
        System.out.println("Score:"+score);
        Main.setScore(score);
    }

    public double getFPSMean() {
        return FPSMean;
    }


    public obj getObject () {
        return object;
    }

}