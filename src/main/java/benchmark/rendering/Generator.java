package benchmark.rendering;

import benchmark.rendering.objects.IObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Generator implements Runnable{

    RenderFrame renderFrame;
    RenderPanel renderPanel;

    public Generator(){
        renderPanel = new RenderPanel();
        renderFrame = new RenderFrame(renderPanel);
        run();
    }
    @Override
    public void run() {

    }
}
