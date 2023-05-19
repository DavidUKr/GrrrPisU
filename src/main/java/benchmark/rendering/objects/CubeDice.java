package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Square;
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
    ArrayList<Square> TRIS = new ArrayList<>();
    ArrayList<Vertex> VERTS=new ArrayList<>();

    public CubeDice(GL2 gl, float x, float y, float z){
        Vertex vA = new Vertex(100.0f, 100.0f, 100.0f);
        Vertex vB = new Vertex(100.0f, 100.0f, -100.0f);
        Vertex vC = new Vertex(100.0f, -100.0f, -100.0f);
        Vertex vD = new Vertex(100.0f, -100.0f, 100.0f);
        Vertex vE = new Vertex(-100.0f, -100.0f, 100.0f);
        Vertex vF = new Vertex(-100.0f, -100.0f, -100.0f);
        Vertex vG = new Vertex(-100.0f, 100.0f, -100.0f);
        Vertex vH = new Vertex(-100.0f, 100.0f, 100.0f);

        VERTS.addAll(List.of(vA,vB,vC,vD,
                            vE,vF,vG,vH));

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

        gl.glColor3i(200,100,34);

        gl.glBegin(GL2.GL_TRIANGLES);
        for(Square s : TRIS)
        {
            for(Vertex v: s.getVERTS()){
                gl.glVertex3d(v.x, v.y, v.z);
            }
        }
        gl.glEnd();
    }

    @Override
    public IObject getObject()
    {
        return null;
    }
}