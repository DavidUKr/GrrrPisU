package benchmark.OpenGL;

import com.jogamp.opengl.GLAutoDrawable;

public interface JOGLInterface {
    double getResolution(GLAutoDrawable drawable);

    //void getRenderingTime(GLAutoDrawable drawable);

    void getFrameRate(GLAutoDrawable drawable);
}
