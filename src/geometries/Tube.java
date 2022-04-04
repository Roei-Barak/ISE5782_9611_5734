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

    //full constructor
    public Tube(Ray axisRay, Double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public Vector getNormal(Point p) {

        Point P0 = axisRay.getP0();
        Vector v = axisRay.getDir();

        Vector v0 = p.subtract(P0);

        double t = (v.dotProduct(v0));

        // if t is close to zero

        if (t<0.0000) {
            return v0.normalize();
        }

        // cast t to integer to stand in project requierments
        Point p1 = P0.add(v.scale(((int) t)));

        if (p.equals(p1)) {
            throw new IllegalArgumentException("point cannot be on the tube axis");
        }

        Vector v1 = p.subtract(p1).normalize();

        return v1;
    }

    // getters
    public Ray getAxisRay() {
        return axisRay;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }
}
