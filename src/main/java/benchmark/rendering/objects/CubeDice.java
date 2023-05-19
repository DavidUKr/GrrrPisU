package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Square;
import benchmark.rendering.basicComponents.Vertex;
import benchmark.rendering.objects.IObject;
import com.jogamp.opengl.GL2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class CubeDice implements IObject
{
    ArrayList<Square> TRIS = new ArrayList<>();
    ArrayList<Path2D> PATHS=new ArrayList<Path2D>();

    public CubeDice(GL2 gl, float x, float y, float z){
        Vertex vA = new Vertex(100.0f, 100.0f, 100.0f);
        Vertex vB = new Vertex(100.0f, 100.0f, -100.0f);
        Vertex vC = new Vertex(100.0f, -100.0f, -100.0f);
        Vertex vD = new Vertex(100.0f, -100.0f, 100.0f);
        Vertex vE = new Vertex(-100.0f, -100.0f, 100.0f);
        Vertex vF = new Vertex(-100.0f, -100.0f, -100.0f);
        Vertex vG = new Vertex(-100.0f, 100.0f, -100.0f);
        Vertex vH = new Vertex(-100.0f, 100.0f, 100.0f);

        //ABCD
        TRIS.add(new Square(vA, vB, vC, vD, Color.WHITE));

        //CDEF
        TRIS.add(new Square(vC, vD, vE, vF, Color.RED));

        //BCFG
        TRIS.add(new Square(vB, vC, vF, vG, Color.YELLOW));

        //ADEH
        TRIS.add(new Square(vA, vD, vE, vH, Color.BLUE));

        //ABGH
        TRIS.add(new Square(vA, vB, vG, vH, Color.GREEN));

        //EFGH
        TRIS.add(new Square(vE, vF, vG, vH, Color.ORANGE));

        for(Square s : TRIS)
        {
            Path2D path = new Path2D.Double();
            path.moveTo(s.v1.x, s.v1.y);
            path.lineTo(s.v2.x, s.v2.y);
            path.lineTo(s.v3.x, s.v3.y);
            path.lineTo(s.v4.x, s.v4.y);
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