package OpenGL;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

public class JOGL implements GLEventListener {
    public static void main(String[] args) {
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
        glCanvas.addGLEventListener(new JOGL());

        JFrame jFrame = new JFrame("Score");
        jFrame.getContentPane().add(glCanvas);
        jFrame.setSize(640, 480);
        jFrame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable drawable) { //Query the vendor and version of the OpenGL
        // Initialization code
        GL gl = drawable.getGL();
        String vendor = gl.glGetString(GL.GL_VENDOR);
        String version = gl.glGetString(GL.GL_VERSION);
        System.out.println("OpenGL Vendor: " + vendor);
        System.out.println("OpenGL Version: " + version);
        String extensions = gl.glGetString(GL.GL_EXTENSIONS);
        System.out.println("Supported Extensions: " + extensions);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Cleanup code
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        // Rendering code
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // Resize code
    }

}
