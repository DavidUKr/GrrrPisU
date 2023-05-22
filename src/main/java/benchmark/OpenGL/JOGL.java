package benchmark.OpenGL;

//cpackage benchmark.OpenGL;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import java.io.IOException;

public class JOGL implements JOGLInterface{

    private GLCanvas glCanvas;
    private GLWindow window;
    private int ScreenWidth=1000;
    private int ScreenHeight=700;
    private float unitsWide=10;

    private EventListener eventListener;
    public void renderGL(obj OBJECT) {
        GLProfile.initSingleton();
        GLProfile glProfile = GLProfile.get(GLProfile.GL2);

        GLCapabilities glCapabilities = new GLCapabilities(glProfile);
        //glCapabilities.setDoubleBuffered(true); //to resolve de fps cap
        //glCapabilities.setHardwareAccelerated(true);

        eventListener=new EventListener(this);
        //FPSAnimator animator=new FPSAnimator(window, 60);
        //animator.start();

        /*window=GLWindow.create(glCapabilities);
        window.setSize(ScreenWidth, ScreenHeight);
        window.setResizable(false);
        window.addGLEventListener(eventListener);

        //window.setFullscreen(true);
        window.setVisible(true);*/

        glCanvas=new GLCanvas(glCapabilities);
        glCanvas.addGLEventListener(eventListener);

        RenderFrame renderFrame=new RenderFrame(this);
        renderFrame.getContentPane().add(glCanvas);
        renderFrame.setVisible(true);
    }

    public void init(GLAutoDrawable drawable) { //Query the vendor and version of the benchmark.OpenGL
        // Initialization code
        GL gl = drawable.getGL();

        //INFO
        String vendor = gl.glGetString(GL.GL_VENDOR);
        String version = gl.glGetString(GL.GL_VERSION);
        System.out.println("benchmark.OpenGL Vendor: " + vendor);
        System.out.println("benchmark.OpenGL Version: " + version);
        //String extensions = gl.glGetString(GL.GL_EXTENSIONS);
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
        int viewportHeight = viewportDimensions[3]; //width and height of viewport in pixels

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

    public GLWindow getWindow() {
        return window;
    }

    public GLCanvas getGlCanvas(){
        return glCanvas;
    }

    public int getScreenWidth() {
        return ScreenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        ScreenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return ScreenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        ScreenHeight = screenHeight;
    }

    public float getUnitsWide() {
        return unitsWide;
    }

    public void setUnitsWide(int unitsWide) {
        this.unitsWide = unitsWide;
    }
}
