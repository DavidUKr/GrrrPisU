package benchmark.OpenGL;

import benchmark.rendering.objects.IObject;
import benchmark.rendering.objects.TetrahedronDice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class RenderPanel extends JPanel {

    IObject object= new TetrahedronDice();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);

        for(Path2D path : ((TetrahedronDice)object).getPATHS()){
            g2.draw(path);
        }
    }
}
