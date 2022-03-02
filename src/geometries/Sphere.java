package geometries;

import geometries.Geometry;
import primitives.Point;
import primitives.Vector;

public class Sphere implements Geometry {
    private Point center;
    private double radius;

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center._xyz +
                ", radius=" + radius +
                '}';
    }

    public Vector getNormal(Point p1){

        Vector v=new Vector(p1.subtract(center)._xyz);
        return v.normalize();
    }


}