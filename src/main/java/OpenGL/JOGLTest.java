package OpenGL;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class JOGLTest implements GLEventListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JOGL Test");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new JOGLTest());
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }
}
