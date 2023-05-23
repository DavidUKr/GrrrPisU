/*package benchmark.OpenGL;

import benchmark.rendering.objects.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class RenderPanel extends JPanel {

    //IObject object= new TetrahedronDice();
    //IObject object= new CubeDice();
    //IObject object = new D20Dice();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);

        //for(Path2D path : ((TetrahedronDice)object).getPATHS()){
        //for(Path2D path : ((CubeDice)object).getPATHS()){
        for(Path2D path : ((D20Dice)object).getPATHS()){
            g2.draw(path);
        }
    }
}
*/