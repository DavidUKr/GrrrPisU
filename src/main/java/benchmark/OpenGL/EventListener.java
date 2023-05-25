package benchmark.OpenGL;

import benchmark.rendering.objects.CubeDice;
import benchmark.rendering.objects.D20Dice;
import benchmark.rendering.objects.IObject;
import benchmark.rendering.objects.TetrahedronDice;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class EventListener implements GLEventListener
{
    private obj OBJECT;
    private IObject object;

    private JOGL jogl;
    private static GL2 gl;
    private double totalTime=0;
    private int numIterations=0;

    GLAutoDrawable drawable;

    public EventListener(JOGL jogl)
    {
        super();
        //totalTime=0;
        //numIterations=0;
        this.jogl=jogl;
    }
    @Override
    public void init(GLAutoDrawable drawable)
    {
        //totalTime=0;
        //numIterations=0;
        gl=drawable.getGL().getGL2();
        gl.glClearColor(0,0,0,1);

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
        gl.glRotatef(-1, 1,1,0);

        float size=2;
        long startTime = System.nanoTime();

         //gl.glColor4f(0,1,0,1);
        gl.glBegin(GL2.GL_QUADS);
            //Front face
            gl.glColor3f(1,0.5f,0.5f); //red
            gl.glVertex3f(-size, -size, size);
            gl.glVertex3f(size, -size, size);
            gl.glVertex3f(size, size, size);
            gl.glVertex3f(-size, size, size);

            // Back face
            gl.glColor3f(1,1,0); //yellow
            gl.glVertex3f(size, -size, -size);
            gl.glVertex3f(-size, -size, -size);
            gl.glVertex3f(-size, size, -size);
            gl.glVertex3f(size, size, -size);

            // Left face
            gl.glColor3f(1,1,1); //white
            gl.glVertex3f(-size, -size, -size);
            gl.glVertex3f(-size, -size, size);
            gl.glVertex3f(-size, size, size);
            gl.glVertex3f(-size, size, -size);

            // Right face
            gl.glColor3f(0,1,1); //turquoise
            gl.glVertex3f(size, -size, size);
            gl.glVertex3f(size, -size, -size);
            gl.glVertex3f(size, size, -size);
            gl.glVertex3f(size, size, size);

            // Top face
            gl.glColor3f(0,0,1); // blue
            gl.glVertex3f(-size, size, size);
            gl.glVertex3f(size, size, size);
            gl.glVertex3f(size, size, -size);
            gl.glVertex3f(-size, size, -size);

            // Bottom face
            gl.glColor3f(1,0,1); //magenta
            gl.glVertex3f(-size, -size, -size);
            gl.glVertex3f(size, -size, -size);
            gl.glVertex3f(size, -size, size);
            gl.glVertex3f(-size, -size, size);

        gl.glEnd();
        numIterations++;
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        totalTime = totalTime+elapsedTime;

        //System.out.println("start: "+numIterations + " end: "+endTime+ ": total: "+totalTime + "; Thread"+Thread.currentThread().getName());

        // renderObj(gl);
    }

    public double computeMeanRenderingTime(double totalTime, int numIterations) {

        totalTime=getTotalTime();
        numIterations=getNumIterations();
        //System.out.println("debug:itNum:"+numIterations+":totalTime:"+totalTime);
        if (numIterations > 0) {
            double meanRenderingTime = totalTime / numIterations;
            //System.out.println("Mean rendering time: " + meanRenderingTime + " ms");
            return  meanRenderingTime;
        } else {
            // System.out.println("No rendering iterations performed.");
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


    public void renderObj(GL2 gl2){

        OBJECT=obj.TETRAHEDRON;

        switch(OBJECT)
        {
            case TETRAHEDRON -> {
                object=new TetrahedronDice(gl2, 0 ,0, 0);
            }
            case CUBE -> {
                object=new CubeDice(gl2, 0 ,0, 0);
            }
            /*case SPHERE -> {

            }*/
            case D20 -> {
                object=new D20Dice(gl2, 0, 0, 0);
            }
            default -> {
                System.out.println("rendering default");
                object=new TetrahedronDice(gl2, 0, 0, 0);
            }
        }
    }
}
