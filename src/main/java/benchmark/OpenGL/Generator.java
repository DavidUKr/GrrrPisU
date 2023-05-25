package benchmark.OpenGL;

import UI.Controllers.LoadingScreenController;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLContext;

import java.io.IOException;

public class Generator implements Runnable {

    private JOGL jogl;
    private Thread genThread;
    private boolean running;
    private int cycle_count = 0;
    private obj object;

    private EventListener eventL = new EventListener(jogl);
    private double FPSMean = 0;
    LoadingScreenController loadingScreenController;


    private int FPS = 5;


    public Generator(LoadingScreenController loadingController) throws IOException {
        loadingScreenController = loadingController;

        setObject(obj.TETRAHEDRON);
        jogl = new JOGL();
        eventL = new EventListener(jogl);
        loadingScreenController.increaseProg(5);
        jogl.renderGL(object);
        start();
        loadingScreenController.increaseProg(6);
    }


    public void start() {
        genThread = new Thread(this);
        running = true;
        genThread.start();
    }

    public void stop() {
        running = false;
    }

    public double getScore() {
        double score = 0;
        double FPSMean = getFPSMean();

        double totalTime = eventL.getTotalTime();
        int numIteration = eventL.getNumIterations();

        //long timeMilliseconds = (long) (totalTime / 1000000);

        double resolution = jogl.getResolutionValue();
        double numitor = FPSMean * resolution;
        System.out.println("Res " + resolution);

        System.out.println("Product " + numitor);
        double time = eventL.computeMeanRenderingTime(totalTime, numIteration);

        //double time = eventL.computeMeanRenderingTime();

        if (time != 0)
            score = (FPSMean * resolution) / time;
        else
            return -1;
        return score;
    }

    public void setObject (obj object){
        this.object = object;
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
                cycle_count++;
            }

            if (cycle_count == 5) {
                stop();
                double s = getScore();
                System.out.println("Score is " + s);

                if (cycle_count == 20) {
                    stop();
                    double s = getScore();
                    System.out.println("done rendering " + s);

                }
            }
            FPSMean = frameSum / 20;
            System.out.println("The mean of fps is " + FPSMean);

        }
    }

    public double getFPSMean () {
        System.out.println("FPS " + FPSMean);
        return FPSMean;
    }
        /** public void getRenderingTime() {
         long startTime = 0;
         long endTime = 0;

         startTime = System.nanoTime();
         run();
         endTime = System.nanoTime();
         long renderingTime = endTime - startTime;
         System.out.print("\nRendering time "+renderingTime);
         }*/

        public obj getObject () {
            return object;
        }

}