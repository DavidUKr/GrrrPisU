package benchmark.OpenGL;
import benchmark.rendering.objects.IObject;
import benchmark.rendering.objects.TetrahedronDice;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import main_pack.Main;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.Path2D;

public class JOGL implements GLEventListener, JOGLInterface {

    GLCanvas glCanvas;
    JFrame jFrame;
    IObject object;
    obj OBJECT;
    public void renderGL(obj OBJECT) {
        this.OBJECT=OBJECT;

        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        glCanvas = new GLCanvas(glCapabilities);
        glCanvas.addGLEventListener(new JOGL());

        GLCapabilities caps = new GLCapabilities(GLProfile.getDefault());
        GLCanvas canvas = new GLCanvas(caps);
        GLContext context = canvas.getContext();

        jFrame=new RenderFrame();
        jFrame.getContentPane().add(glCanvas);

        jFrame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable drawable) { //Query the vendor and version of the benchmark.OpenGL
        // Initialization code

        GL gl = drawable.getGL();

        String vendor = gl.glGetString(GL.GL_VENDOR);
        String version = gl.glGetString(GL.GL_VERSION);
        System.out.println("benchmark.OpenGL Vendor: " + vendor);
        System.out.println("benchmark.OpenGL Version: " + version);
        String extensions = gl.glGetString(GL.GL_EXTENSIONS);
        //System.out.println("Supported Extensions: " + extensions);
        getResolution(drawable);
        getFrameRate(drawable);
    }

    @Override
    public void getResolution(GLAutoDrawable drawable){
        GLContext context = drawable.getContext(); //access the context from which we extract the inf
        int[] viewportDimensions = new int[4];
        context.getGL().glGetIntegerv(GL2.GL_VIEWPORT, viewportDimensions, 0);
        int viewportWidth = viewportDimensions[2];
        int viewportHeight = viewportDimensions[3];
        System.out.println("Viewport resolution: " + viewportWidth + "x" + viewportHeight);
    }
    @Override
    public void getFrameRate(GLAutoDrawable drawable){
        int frameCount = 0;
        long startTime = System.currentTimeMillis();

        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;

        if (elapsedTime >= 1000) {
            float fps = (float) frameCount / (elapsedTime / 1000.0f);
            System.out.println("Frame rate: " + fps + " fps");

            // Reset the variables for the next interval
            frameCount = 0;
            startTime = currentTime;
        }

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup code
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl2 = drawable.getGL().getGL2();
        // Clear the color and depth buffers
        gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        // Set up the view and projection matrices
        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();

        renderObj(gl2);

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // Resize code
    }

    public GLCanvas getGlCanvas() {
        return glCanvas;
    }

    public void renderObj(GL2 gl2){

        OBJECT=obj.TETRAHEDRON;

        switch(OBJECT){
            case TETRAHEDRON -> {
                //object=new TetrahedronDice(gl2);
                object=new TetrahedronDice(gl2, 0.0f, 0.0f, 0.0f);
            }
            case CUBE -> {}
            case SPHERE -> {}
            case D20 -> {}
            default -> {
                System.out.println("rendering default");
                //object=new TetrahedronDice(gl2);
                object=new TetrahedronDice(gl2, 0.0f, 0.0f, 0.0f);
            }
        }
    }
}
