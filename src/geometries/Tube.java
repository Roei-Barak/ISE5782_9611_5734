package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Tube class
 *
 * @authors Michael @ Roy
 */

public class Tube implements Geometry {
    final Ray axisRay;
    final Double radius;

    public Tube(Ray axisRay, Double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    public Double getRadius() {
        return radius;
    }
}
