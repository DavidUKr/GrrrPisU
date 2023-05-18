package benchmark.OpenGL;

import javax.swing.*;
import java.awt.*;

public class RenderFrame {
    JFrame frame;

    public RenderFrame(RenderPanel renderPanel){
        JFrame frame = new JFrame();
        JOGL.initFrameContent(renderPanel);

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(1000, 700);
        frame.setVisible(true);
    }
}
