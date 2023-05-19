package benchmark.OpenGL;

import main_pack.Main;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RenderFrame extends JFrame {

    public RenderFrame(){
        super("Render");

        setSize(1000, 700);
        setLocationRelativeTo(null);
        //overriding close sequence to stop loop
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Main.getGenerator().stop();
                super.windowClosed(e);
            }
        });
    }
}
