package benchmark.OpenGL;

import benchmark.rendering.objects.IObject;
import benchmark.rendering.objects.TetrahedronDice;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {
    private obj OBJECT;
    IObject object;

    JOGL jogl;

    public EventListener(JOGL jogl){
        super();
        this.jogl=jogl;
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

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
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
//        GL2 gl2 = drawable.getGL().getGL2();
//        // Clear the color and depth buffers
//        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
//        // Set up the view and projection matrices
//        gl2.glMatrixMode(GL2.GL_MODELVIEW);
//        gl2.glLoadIdentity();
//
//        renderObj(gl2);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public void renderObj(GL2 gl2){

        OBJECT=obj.TETRAHEDRON;

        switch(OBJECT){
            case TETRAHEDRON -> {
                object=new TetrahedronDice(gl2);
            }
            case CUBE -> {}
            case SPHERE -> {}
            case D20 -> {}
            default -> {
                System.out.println("rendering default");
                object=new TetrahedronDice(gl2);
            }
        }
    }
}
