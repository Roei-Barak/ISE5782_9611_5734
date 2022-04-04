package geometries;

import primitives.Point;
import primitives.Vector;

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
}
