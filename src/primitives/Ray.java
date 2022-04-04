package primitives;

import primitives.Point;
import primitives.Vector;

import java.util.Objects;

/**
 * class Ray
 *
 * @authors Michael @ Roy
 */

public class Ray {
    private Point p0;
    private Vector dir;

    /**
     * full constructor
     * @param p0 point
     * @param dir vector
     */
    public Ray(Point p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir.normalize();
    }

    // getters

    public Point getP0() {
        return p0;
    }

    public Vector getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return "Ray{" + p0 + " " + dir + '}';
    }

}
