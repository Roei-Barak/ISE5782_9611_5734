package geometries;

import primitives.Ray;


/**
 * Cylinder class
 *
 * @authors Michael @ Roy
 */

public class Cylinder extends Tube {
    private double height;

    public Cylinder(Ray axisRay, Double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}
