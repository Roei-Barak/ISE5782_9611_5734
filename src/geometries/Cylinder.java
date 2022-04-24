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

    /**
     * https://stackoverflow.com/questions/36266357/normal-on-of-a-cylinder
     * source: Dans presentation: "Introduction to Software Engineering" page: 37
     * @param point
     * @return normal vector to Cylinder
     */

    @Override
    public Vector getNormal(Point point) {
        //if the vector is contained in one of the cylinder bases than the vector from one point in the base to it

        //would be orthogonal to the axis ray vector

        Point base0 = axisRay.getP0();
        Point base1 = base0.add(axisRay.getDir().scale((int) height));

        if (point.equals(base0) || point.equals(base1))
            return axisRay.getDir();

        Vector v1 = point.subtract(base0);
        Vector v2 = point.subtract(base1);
        if (v1.dotProduct(axisRay.getDir()) == 0 || v2.dotProduct(axisRay.getDir()) == 0) {
            return axisRay.getDir();
        } else
            return super.getNormal(point);
    }

    /**
     * getHeight function
     * @return Cylinder height
     */
    public double getHeight() {
        return height;
    }
}
