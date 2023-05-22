package benchmark.OpenGL;

import com.jogamp.opengl.GLAutoDrawable;

import java.io.IOException;

public interface JOGLInterface {
    void getResolution(GLAutoDrawable drawable);

    //void getRenderingTime(GLAutoDrawable drawable);

    void getFrameRate(GLAutoDrawable drawable);
}
