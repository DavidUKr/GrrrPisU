package benchmark.OpenGL;

import com.jogamp.opengl.GLAutoDrawable;

public interface JOGLInterface {
    void getResolution(GLAutoDrawable drawable);

    void getFrameRate(GLAutoDrawable drawable);
}
