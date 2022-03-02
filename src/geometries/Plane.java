package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry{

    private Point q0;
    private Vector normal;

    public Plane(Point q0, Vector normal) {
        this.q0 = q0;
        this.normal = normal.normalize();
    }

    public Plane(Point x,Point y, Point z)
    {
        //doing subtract to check if there's two point that coalesce
        //then throwing exception from the constructor of Vector
        Vector check1=x.subtract(y);
        Vector check2=x.subtract(z);
        Vector check3=z.subtract(y);
        Vector a = new Vector(y.subtract(x)._xyz);
        Vector b = new Vector(z.subtract(x)._xyz);
        normal = new Vector(a.crossProduct(b).normalize()._xyz);
        q0 = new Point(x._xyz);
    }
    @Override
    public Vector getNormal(Point point) {
        return normal;
    }

    public Point getQ0() {
        return q0;
    }

    public Vector getNormal() {
        return normal;
    }
}
