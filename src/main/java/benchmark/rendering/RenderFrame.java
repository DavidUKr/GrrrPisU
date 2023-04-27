package benchmark.rendering;

import javax.swing.*;
import java.awt.*;

public class RenderFrame {
    JFrame frame;

    public RenderFrame(RenderPanel renderPanel){
        JFrame frame = new JFrame();

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
