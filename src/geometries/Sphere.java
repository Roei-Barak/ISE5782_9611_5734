package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Sphere class
 *
 * @authors Michael @ Roy
 */

public class Sphere implements Geometry {
    private Point center;
    private double radius;

    /**
     * full constructor
     * @param center
     * @param radius
     */
    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    //getters

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     *
     * @return Sphere String
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center.xyz +
                ", radius=" + radius +
                '}';
    }

    /**
     *
     * @param p1
     * @return new normalize vector to the sphere
     */
    public Vector getNormal(Point p1){

        Vector v=new Vector(p1.subtract(center).xyz);
        return v.normalize();
    }


}