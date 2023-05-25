package benchmark.OpenGL;


import benchmark.rendering.objects.CubeDice;
import benchmark.rendering.objects.D20Dice;
import benchmark.rendering.objects.IObject;
import benchmark.rendering.objects.TetrahedronDice;

import benchmark.rendering.basicComponents.*;
import benchmark.rendering.objects.*;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;


import java.util.ArrayList;

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

        System.out.println("start: "+numIterations + " end: "+endTime+ ": total: "+totalTime);

        // renderObj(gl);
    }

    public double computeMeanRenderingTime(double totalTime, int numIterations) {

        totalTime=getTotalTime();
        numIterations=getNumIterations();
        System.out.println("debug:time+"+numIterations);
        if (numIterations > 0) {
            double meanRenderingTime = totalTime / numIterations;
           // System.out.println("Mean rendering time: " + meanRenderingTime + " ms");
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

        //gl.glRotatef(-1, 1,1,0);

        //gl.glColor4f(0,1,0,1);

        //renderObj(gl);
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


    public void renderObj(GL2 gl2)
    {
        float size=1;

        OBJECT = obj.TETRAHEDRON;
        //OBJECT=obj.CUBE;
        //OBJECT=obj.D20;

        switch(OBJECT)
        {
            case TETRAHEDRON -> {

                object=new TetrahedronDice(gl2, 0 ,0, 0);
            }
           /** case CUBE -> {
                object=new CubeDice(gl2, 0 ,0, 0);

                object = new TetrahedronDice(gl2, 0 ,0, 0);
                ArrayList<Vertex> VERTS = object.getVERTS();

                Vertex vA = VERTS.get(0);
                Vertex vB = VERTS.get(1);
                Vertex vC = VERTS.get(2);
                Vertex vD = VERTS.get(3);

                gl.glBegin(GL2.GL_TRIANGLES);

                //ABC
                gl.glColor3f(1,0.5f,0.5f); //red
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());

                //ABD
                gl.glColor3f(1,1,0); //yellow
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());

                //CDA
                gl.glColor3f(1,1,1); //white
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());

                // Right face
                gl.glColor3f(0,1,1); //turquoise
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());

                gl.glEnd();
            }*/
            case CUBE -> {
                object = new CubeDice(gl2, 0 ,0, 0);
                ArrayList<Vertex> VERTS = object.getVERTS();

                Vertex vA = VERTS.get(0);
                Vertex vB = VERTS.get(1);
                Vertex vC = VERTS.get(2);
                Vertex vD = VERTS.get(3);
                Vertex vE = VERTS.get(4);
                Vertex vF = VERTS.get(5);
                Vertex vG = VERTS.get(6);
                Vertex vH = VERTS.get(7);

                gl.glBegin(GL2.GL_TRIANGLES);

                //ABC + ADC
                gl.glColor3f(1,0.5f,0.5f); //red
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());

                gl.glColor3f(1,0.5f,0.5f); //red
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());

                //DCF + DEF
                gl.glColor3f(1,1,0); //yellow
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                gl.glColor3f(1,1,0); //yellow
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                //BCF + BGF
                gl.glColor3f(1,1,1); //white
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                gl.glColor3f(1,1,1); //white
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                //ADE + AHE
                gl.glColor3f(0,1,1); //turquoise
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());

                gl.glColor3f(0,1,1); //turquoise
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());

                //HGB + HAB
                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());

                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());

                //EFG + EHG
                gl.glColor3f(1,0,1); //magenta
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());

                gl.glColor3f(1,0,1); //magenta
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());

                gl.glEnd();
            }
            /*case SPHERE -> {

            }*/
            case D20 -> {

                object=new D20Dice(gl2, 0, 0, 0);

                object = new D20Dice(gl2, 0, 0, 0);
                ArrayList<Vertex> VERTS = object.getVERTS();

                Vertex vA = VERTS.get(0);
                Vertex vB = VERTS.get(1);
                Vertex vC = VERTS.get(2);
                Vertex vD = VERTS.get(3);
                Vertex vE = VERTS.get(4);
                Vertex vF = VERTS.get(5);
                Vertex vG = VERTS.get(6);
                Vertex vH = VERTS.get(7);
                Vertex vI = VERTS.get(8);
                Vertex vJ = VERTS.get(9);
                Vertex vK = VERTS.get(10);
                Vertex vL = VERTS.get(11);

                gl.glBegin(GL2.GL_TRIANGLES);

                //ABC
                gl.glColor3f(1,0.5f,0.5f); //red
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());

                //ABD
                gl.glColor3f(0.0f, 1.0f, 0.0f); //green
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());

                //HKL
                gl.glColor3f(0.0f, 1.0f, 0.0f); //green
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vK.getX(), vK.getY(), vK.getZ());
                gl.glVertex3f(vL.getX(), vL.getY(), vL.getZ());

                //EHL
                gl.glColor3f(1,0.5f,0.5f); //red
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vL.getX(), vL.getY(), vL.getZ());

                //CGK
                gl.glColor3f(1,1,0); //yellow
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());
                gl.glVertex3f(vK.getX(), vK.getY(), vK.getZ());

                //CJK
                gl.glColor4f(1.0f, 0.0f, 1.0f, 0.0f); //purple
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vJ.getX(), vJ.getY(), vJ.getZ());
                gl.glVertex3f(vK.getX(), vK.getY(), vK.getZ());

                //BCG
                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());

                //ACJ
                gl.glColor3f(1.0f, 0.5f, 0.0f); //orange
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vC.getX(), vC.getY(), vC.getZ());
                gl.glVertex3f(vJ.getX(), vJ.getY(), vJ.getZ());

                //BDF
                gl.glColor3f(1.0f, 0.5f, 0.0f); //orange
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                //ADI
                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vI.getX(), vI.getY(), vI.getZ());

                //AIJ
                gl.glColor3f(1,1,1); //white
                gl.glVertex3f(vA.getX(), vA.getY(), vA.getZ());
                gl.glVertex3f(vI.getX(), vI.getY(), vI.getZ());
                gl.glVertex3f(vJ.getX(), vJ.getY(), vJ.getZ());

                //BFG
                gl.glColor3f(1,1,1); //white
                gl.glVertex3f(vB.getX(), vB.getY(), vB.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());

                //DEI
                gl.glColor3f(1,1,0); //yellow
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vI.getX(), vI.getY(), vI.getZ());

                //DEF
                gl.glColor4f(1.0f, 0.0f, 1.0f, 0.0f); //purple
                gl.glVertex3f(vD.getX(), vD.getY(), vD.getZ());
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());

                //IJL
                gl.glColor3f(0.5f, 1.0f, 1.0f); //cyan
                gl.glVertex3f(vI.getX(), vI.getY(), vI.getZ());
                gl.glVertex3f(vJ.getX(), vJ.getY(), vJ.getZ());
                gl.glVertex3f(vL.getX(), vL.getY(), vL.getZ());

                //FGH
                gl.glColor3f(0.5f, 1.0f, 1.0f); //cyan
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());

                //EFH
                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vF.getX(), vF.getY(), vF.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());

                //EIL
                gl.glColor3f(1.0f, 0.5f, 0.0f); //orange
                gl.glVertex3f(vE.getX(), vE.getY(), vE.getZ());
                gl.glVertex3f(vI.getX(), vI.getY(), vI.getZ());
                gl.glVertex3f(vL.getX(), vL.getY(), vL.getZ());

                //JKL
                gl.glColor3f(0,0,1); //blue
                gl.glVertex3f(vJ.getX(), vJ.getY(), vJ.getZ());
                gl.glVertex3f(vK.getX(), vK.getY(), vK.getZ());
                gl.glVertex3f(vL.getX(), vL.getY(), vL.getZ());

                //GHK
                gl.glColor3f(1.0f, 0.5f, 0.0f); //orange
                gl.glVertex3f(vG.getX(), vG.getY(), vG.getZ());
                gl.glVertex3f(vH.getX(), vH.getY(), vH.getZ());
                gl.glVertex3f(vK.getX(), vK.getY(), vK.getZ());

                gl.glEnd();
            }
            default -> {
                System.out.println("rendering default");
                object=new TetrahedronDice(gl2, 0, 0, 0);
            }
        }
    }
}
