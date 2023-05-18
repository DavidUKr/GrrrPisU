package benchmark.OpenGL;

import javax.swing.*;

public class RenderFrame {
    JFrame frame;

    public RenderFrame(){
        JFrame frame = new JFrame();
        frame.setSize(1000, 700);
    }

    public JFrame getFrame(){
        return frame;
    }
}
