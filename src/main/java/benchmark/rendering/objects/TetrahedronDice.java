package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Triangle;
import benchmark.rendering.basicComponents.Vertex;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLDrawable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public class TetrahedronDice implements IObject
{
    ArrayList<Triangle> TRIS = new ArrayList<>();
    ArrayList<Vertex> VERTS = new ArrayList<>();

    public TetrahedronDice(GL2 gl, float x, float y, float z){
        Vertex vA = new Vertex(100.0f, 100.0f, 100.0f);
        Vertex vB = new Vertex(-100.0f, -100.0f, 100.0f);
        Vertex vC = new Vertex(-100.0f, 100.0f, -100.0f);
        Vertex vD = new Vertex(100.0f, -100.0f, -100.0f);

        VERTS.addAll(List.of(vA,vB,vC,vD));
        //ABC
        TRIS.add(new Triangle(vA, vB, vC, Color.WHITE));

        //ABD
        TRIS.add(new Triangle(vA, vB, vD, Color.RED));

        //ACD
        TRIS.add(new Triangle(vC, vD, vA, Color.GREEN));

        //BCD
        TRIS.add(new Triangle(vC, vD, vB, Color.BLUE));

        gl.glColor3i(200,100,34);

        gl.glBegin(GL2.GL_TRIANGLES);
        for(Triangle t : TRIS)
        {
            for(Vertex v: t.getVERTS()){
                gl.glVertex3d(v.x, v.y, v.z);
            }
        }
        gl.glEnd();
    }

    @Override
    public IObject getObject()
    {
        return this;
    }
}