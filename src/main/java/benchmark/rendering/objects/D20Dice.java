package benchmark.rendering.objects;

import benchmark.rendering.basicComponents.Triangle;
import benchmark.rendering.basicComponents.Vertex;
import com.jogamp.opengl.GL2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class D20Dice implements IObject//DnD/D20/Icosahedron
{
    ArrayList<Triangle> TRIS = new ArrayList<>();
    ArrayList<Path2D> PATHS=new ArrayList<Path2D>();

    public D20Dice(GL2 gl, float x, float y, float z)
    {//20 faces - 12 vertices
        float ex = 100.0f;
        float phi = (float) ((1.0f + Math.sqrt(5)) / 2.0f);

        Vertex vA = new Vertex(-ex, ex*phi, 0.0f);
        Vertex vB = new Vertex(ex, ex*phi, 0.0f);
        Vertex vC = new Vertex(0.0f, ex, ex*phi);
        Vertex vD = new Vertex(0.0f, ex, -ex*phi);

        Vertex vK = new Vertex(0.0f, -ex, ex*phi);
        Vertex vH = new Vertex(ex, -ex*phi, 0.0f);
        Vertex vL = new Vertex(-ex, -ex*phi, 0.0f);
        Vertex vE = new Vertex(0.0f, -ex, -ex*phi);

        Vertex vG = new Vertex(ex*phi, 0.0f, ex);
        Vertex vJ = new Vertex(-ex*phi, 0.0f, ex);

        Vertex vF = new Vertex(ex*phi, 0.0f, -ex);
        Vertex vI = new Vertex(-ex*phi, 0.0f, -ex);

        TRIS.add(new Triangle(vA, vB, vC, Color.RED));//1-ABC
        TRIS.add(new Triangle(vA, vB, vD, Color.GREEN));//7-ABD

        TRIS.add(new Triangle(vH, vK, vL, Color.GREEN));//14-HKL
        TRIS.add(new Triangle(vE, vH, vL, Color.RED));//20-EHL

        TRIS.add(new Triangle(vC, vG, vK, Color.YELLOW));//11-CGK
        TRIS.add(new Triangle(vC, vJ, vK, Color.MAGENTA));//9-CJK

        TRIS.add(new Triangle(vB, vC, vG, Color.BLUE));//13-BCG
        TRIS.add(new Triangle(vA, vC, vJ, Color.ORANGE));//19-ACJ

        TRIS.add(new Triangle(vB, vD, vF, Color.ORANGE));//15-BDF
        TRIS.add(new Triangle(vA, vD, vI, Color.BLUE));//17-ADI

        TRIS.add(new Triangle(vA, vI, vJ, Color.WHITE));//3-AIJ
        TRIS.add(new Triangle(vB, vF, vG, Color.WHITE));//5-BFG

        TRIS.add(new Triangle(vD, vE, vI, Color.YELLOW));//10-DEI
        TRIS.add(new Triangle(vD, vE, vF, Color.MAGENTA));//12-DEF

        TRIS.add(new Triangle(vI, vJ, vL, Color.CYAN));//16-IJL
        TRIS.add(new Triangle(vF, vG, vH, Color.CYAN));//18-FGH

        TRIS.add(new Triangle(vE, vF, vH, Color.BLUE));//2-EFH
        TRIS.add(new Triangle(vE, vI, vL, Color.ORANGE));//8-EIL

        TRIS.add(new Triangle(vJ, vK, vL, Color.BLUE));//6-JKL
        TRIS.add(new Triangle(vG, vH, vK, Color.ORANGE));//4-GHK

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
