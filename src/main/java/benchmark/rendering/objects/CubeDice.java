package benchmark.rendering.objects;

//import benchmark.rendering.basicComponents.Square;
import benchmark.rendering.basicComponents.Triangle;
import benchmark.rendering.basicComponents.Vertex;
import benchmark.rendering.objects.IObject;
import com.jogamp.opengl.GL2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class CubeDice implements IObject
{
    ArrayList<Triangle> TRIS = new ArrayList<>();
    ArrayList<Vertex> VERTS=new ArrayList<>();

    public CubeDice(GL2 gl, float x, float y, float z)
    {
        Vertex vA = new Vertex(+1.0f, +1.0f, +1.0f);
        Vertex vB = new Vertex(+1.0f, +1.0f, -1.0f);
        Vertex vC = new Vertex(+1.0f, -1.0f, -1.0f);
        Vertex vD = new Vertex(+1.0f, -1.0f, +1.0f);
        Vertex vE = new Vertex(-1.0f, -1.0f, +1.0f);
        Vertex vF = new Vertex(-1.0f, -1.0f, -1.0f);
        Vertex vG = new Vertex(-1.0f, +1.0f, -1.0f);
        Vertex vH = new Vertex(-1.0f, +1.0f, +1.0f);

        VERTS.addAll(List.of(vA,vB,vC,vD,
                            vE,vF,vG,vH));


        //ABCD
        //TRIS.add(new Square(vA, vB, vC, vD, Color.WHITE));
        TRIS.add(new Triangle(vA, vB, vC, Color.WHITE));
        TRIS.add(new Triangle(vA, vD, vC, Color.WHITE));

        //CDEF
        //TRIS.add(new Square(vC, vD, vE, vF, Color.RED));
        TRIS.add(new Triangle(vD, vC, vF, Color.RED));
        TRIS.add(new Triangle(vD, vE, vF, Color.RED));

        //BCFG
        //TRIS.add(new Square(vB, vC, vF, vG, Color.YELLOW));
        TRIS.add(new Triangle(vB, vC, vF, Color.YELLOW));
        TRIS.add(new Triangle(vB, vG, vF, Color.YELLOW));

        //ADEH
        //TRIS.add(new Square(vA, vD, vE, vH, Color.BLUE));
        TRIS.add(new Triangle(vA, vD, vE, Color.BLUE));
        TRIS.add(new Triangle(vA, vH, vE, Color.BLUE));

        //ABGH
        //TRIS.add(new Square(vA, vB, vG, vH, Color.GREEN));
        TRIS.add(new Triangle(vH, vG, vB, Color.GREEN));
        TRIS.add(new Triangle(vH, vA, vB, Color.GREEN));

        //EFGH
        //TRIS.add(new Square(vE, vF, vG, vH, Color.ORANGE));
        TRIS.add(new Triangle(vE, vF, vG, Color.ORANGE));
        TRIS.add(new Triangle(vE, vH, vG, Color.ORANGE));
    }

    @Override
    public IObject getObject()
    {
        return null;
    }

    public ArrayList<Vertex> getVERTS()
    {
        return VERTS;
    }
}