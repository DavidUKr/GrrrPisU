package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Triangle;
import benchmark.rendering.basicComponents.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class TetrahedronDice implements IObject
{
    ArrayList<Triangle> TRIS = new ArrayList<>();
    ArrayList<Path2D> PATHS=new ArrayList<Path2D>();

    public TetrahedronDice(){
        Vertex vA = new Vertex(100, 100, 100);
        Vertex vB = new Vertex(-100, -100, 100);
        Vertex vC = new Vertex(-100, 100, -100);
        Vertex vD = new Vertex(100, -100, -100);

        //ABC
        TRIS.add(new Triangle(vA, vB, vC, Color.WHITE));

        //ABD
        TRIS.add(new Triangle(vA, vB, vD, Color.RED));

        //ACD
        TRIS.add(new Triangle(vC, vD, vA, Color.GREEN));

        //BCD
        TRIS.add(new Triangle(vC, vD, vB, Color.BLUE));

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