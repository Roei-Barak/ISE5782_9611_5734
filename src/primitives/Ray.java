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

    public Point getPoint(double t) {
        return new Point(p0.getX()+(dir.scale(t).getX()),
                p0.getY()+(dir.scale(t).getY()),
                p0.getZ()+(dir.scale(t).getZ()));
    }


    public Vector getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return "Ray{" + p0 + " " + dir + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }
}
