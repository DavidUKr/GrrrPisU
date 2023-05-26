package benchmark.OpenGL;


import benchmark.rendering.basicComponents.*;
import benchmark.rendering.objects.*;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.ArrayList;

import static com.jogamp.opengl.GL.GL_DEPTH_TEST;

public class EventListener implements GLEventListener
{
    private obj OBJECT;
    private IObject object;

    private JOGL jogl;
    private static GL2 gl;

    private long totalTime=0;
    private int numIterations=0;

    GLAutoDrawable drawable;


    public EventListener(JOGL jogl)
    {
        super();
        this.jogl=jogl;
    }
    @Override
    public void init(GLAutoDrawable drawable)
    {
        gl=drawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);
        gl.glEnable(GL2.GL_DEPTH_TEST);

        //INFO
        String vendor = gl.glGetString(GL.GL_VENDOR);
        String version = gl.glGetString(GL.GL_VERSION);
        System.out.println("benchmark.OpenGL Vendor: " + vendor);
        System.out.println("benchmark.OpenGL Version: " + version);
        String extensions = gl.glGetString(GL.GL_EXTENSIONS);

        //System.out.println("Supported Extensions: " + extensions);
        jogl.getResolution(drawable);
        jogl.getFrameRate(drawable);

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable)
    {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable)
    {
        //Clear the color and depth buffers
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
        gl.glRotatef(-1, 1,1,0);


        long startTime = System.nanoTime();

        renderObj(gl);

        numIterations++;
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        totalTime = totalTime+elapsedTime;

        //System.out.println("start: "+numIterations + " end: "+endTime+ ": total: "+totalTime + "; Thread"+Thread.currentThread().getName());

    }

    public long computeMeanRenderingTime() {

        //totalTime=getTotalTime();
        //numIterations=getNumIterations();
        if (numIterations > 0) {
            //System.out.println("Mean rendering time: " + meanRenderingTime + " ms");
            return (long)(totalTime / numIterations);
        } else {
            System.out.println("No rendering iterations performed.");
            return 0;
        }
    }

    public double getTotalTime() {
        display(drawable);
        return totalTime;
    }

    public int getNumIterations() {
        return numIterations;
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3)
    {
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float unitsTall= jogl.getScreenHeight() /(jogl.getScreenWidth() / jogl.getUnitsWide());
        gl.glOrtho(-jogl.getUnitsWide()/2, jogl.getUnitsWide()/2, -unitsTall/2, unitsTall/2,-5 , 5);
        //GLU glu=new GLU();
        //glu.gluPerspective(100, (float)jogl.getScreenWidth()/jogl.getScreenHeight(), 0.1, 1);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        //gl.glLoadIdentity();
    }

    public void setOBJECT(obj OBJECT){
        this.OBJECT=OBJECT;
    }

    public void renderObj(GL2 gl2)
    {
        switch(OBJECT)
        {
            case TETRAHEDRON -> {
                object = new TetrahedronDice(gl2, 0 ,0, 0);
            }
            case CUBE -> {
                object = new CubeDice(gl2, 0 ,0, 0);
            }
            case D20 -> {
                object = new D20Dice(gl2, 0, 0, 0);
            }
            default -> {
                System.out.println("rendering default");
                object=new TetrahedronDice(gl2, 0, 0, 0);
            }
        }
    }
}
