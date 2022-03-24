package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;


/**
 * Cylinder class
 *
 * @authors Michael @ Roy
 */

public class Cylinder extends Tube {
    private double height;

    // constructor

    public Cylinder(Ray axisRay, Double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }
    @Override
    public Vector getNormal(Point point) {
        return null;
    }


    /**
     * getHeight function
     * @return Cylinder height
     */
    public double getHeight() {
        return height;
    }
}
