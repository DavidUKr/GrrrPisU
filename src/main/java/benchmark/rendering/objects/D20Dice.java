package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Triangle;
import benchmark.rendering.basicComponents.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class D20Dice implements IObject//DnD Dice
{
    ArrayList<Triangle> TRIS = new ArrayList<>();
    ArrayList<Path2D> PATHS=new ArrayList<Path2D>();

    public D20Dice(){
        double phi = (1 + Math.sqrt(5)) / 2;

        Vertex vA = new Vertex(-1, phi, 0);
        Vertex vB = new Vertex(1, phi, 0);
        Vertex vC = new Vertex(-1, -phi, 0);
        Vertex vD = new Vertex(1, -phi, 0);

        Vertex vE = new Vertex(0, -1, phi);
        Vertex vF = new Vertex(0, 1, phi);
        Vertex vG = new Vertex(0, -1, -phi);
        Vertex vH = new Vertex(0, 1, -phi);

        Vertex vI = new Vertex(phi, 0, -1);
        Vertex vJ = new Vertex(phi, 0, 1);
        Vertex vK = new Vertex(-phi, 0, -1);
        Vertex vL = new Vertex(-phi, 0, 1);

        TRIS.add(new Triangle(vA, vB, vF, Color.RED));
        TRIS.add(new Triangle(vB, vA, vE, Color.RED));
        TRIS.add(new Triangle(vA, vF, vG, Color.RED));
        TRIS.add(new Triangle(vA, vG, vC, Color.RED));
        TRIS.add(new Triangle(vA, vC, vE, Color.RED));

        TRIS.add(new Triangle(vD, vB, vE, Color.RED));
        TRIS.add(new Triangle(vB, vD, vH, Color.RED));
        TRIS.add(new Triangle(vB, vH, vF, Color.RED));
        TRIS.add(new Triangle(vB, vF, vE, Color.RED));
        TRIS.add(new Triangle(vC, vG, vL, Color.RED));

        TRIS.add(new Triangle(vG, vC, vK, Color.RED));
        TRIS.add(new Triangle(vG, vK, vD, Color.RED));
        TRIS.add(new Triangle(vG, vD, vH, Color.RED));
        TRIS.add(new Triangle(vG, vH, vL, Color.RED));
        TRIS.add(new Triangle(vE, vC, vK, Color.RED));

        TRIS.add(new Triangle(vC, vE, vI, Color.RED));
        TRIS.add(new Triangle(vC, vI, vL, Color.RED));
        TRIS.add(new Triangle(vC, vL, vK, Color.RED));
        TRIS.add(new Triangle(vD, vH, vJ, Color.RED));
        TRIS.add(new Triangle(vD, vJ, vK, Color.RED));

        for(Triangle t : TRIS)
        {
            Path2D path = new Path2D.Double();
            path.moveTo(t.v1.x, t.v1.y);
            path.lineTo(t.v2.x, t.v2.y);
            path.lineTo(t.v3.x, t.v3.y);
            path.closePath();
            PATHS.add(path);
        }
    }

    public ArrayList<Path2D> getPATHS() {
        return PATHS;
    }

    @Override
    public IObject getObject() {
        return null;
    }
}
