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

    public TetrahedronDice(GL2 gl, float x, float y, float z)
    {
        Vertex vA = new Vertex(+1.0f, +1.0f, +1.0f);
        Vertex vB = new Vertex(-1.0f, -1.0f, +1.0f);
        Vertex vC = new Vertex(-1.0f, +1.0f, -1.0f);
        Vertex vD = new Vertex(+1.0f, -1.0f, -1.0f);

        VERTS.addAll(List.of(vA,vB,vC,vD));
    }

    @Override
    public IObject getObject()
    {
        return this;
    }

    public ArrayList<Vertex> getVERTS()
    {
        return VERTS;
    }
}