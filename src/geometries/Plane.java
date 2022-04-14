package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Plane class
 *
 * @authors Michael @ Roy
 */

public class Plane implements Geometry{

    private Point q0;
    private Vector normal;

    /**
     * full constructor
     * @param q0 Point,
     * @param normal
     */
    public Plane(Point q0, Vector normal) {
        this.q0 = q0;
        this.normal = normal.normalize();
    }

    /**
     * constructor from 3 points
     * @param x
     * @param y
     * @param z
     */

    public Plane(Point x,Point y, Point z)
    {
        //doing subtract to check if there's two point that coalesce
        //then throwing exception from the constructor of Vector
        Vector check1=x.subtract(y);
        Vector check2=x.subtract(z);
        Vector check3=z.subtract(y);
        Vector a = new Vector(y.subtract(x).xyz);
        Vector b = new Vector(z.subtract(x).xyz);
        normal = new Vector(a.crossProduct(b).normalize().xyz);
        q0 = new Point(x.xyz);
    }

    //the point does not matter
    @Override
    public Vector getNormal(Point point) {

        return normal;
    }
    //getter for q0 - plane point
    public Point getQ0() {
        return q0;
    }

    //second function 'getNormal' without point
    public Vector getNormal() {
        return normal;
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        Point P0=ray.getP0();
        Vector v=ray.getDir();
        Vector n=normal;
        //denominator
        double nv = n.dotProduct(v);

        if (isZero(nv)) {
            return null;
        }
        Vector P0_Q=q0.subtract(P0);
        double t=alignZero(n.dotProduct(P0_Q)/nv);
        //if t < 0 the array point to the opposite direction
        // if t==0 the ray origin lay with ×”×§×¨×Ÿ ×œ× ×‘×›×™×•×•×Ÿ ×©×× ×—× ×• ×¨×•×¦×™×
        if(t > 0)
        {
            Point P=P0.add(v.scale(t));
            return List.of(P);
        }

        return null;
        }

}
