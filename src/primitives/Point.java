package primitives;

import java.util.Objects;

/**
 * Point class represent 3d point
 *
 * @authors Michael @ Roy
 */

public class Point {
    /**
     * constuctors
     * @param xyz
     */

    public Point(Double3 xyz) {
        _xyz = xyz;
    }

    public final Double3 _xyz;

    public Point(double x, double y, double z) {
        _xyz = new Double3(x,y,z);
    }

    /**
     *
     * @param o
     * @return isEqual?
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return _xyz.equals(point._xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_xyz);
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Point " + _xyz;
    }

    /**
     *
     * @param vector
     * @return new point: point+vector
     */
    public Point add(Vector vector) {
        return new Point(_xyz.add(vector._xyz));
    }

    /**
     *
     * @param point
     * @return new vector
     */
    public Vector subtract(Point point) {
        Double3 result = _xyz.subtract(point._xyz);
        if (result.equals(Double3.ZERO)){
            throw new IllegalArgumentException("resulting of substructure : Vector (0,0,0,) not allowed");
        }
        return new Vector(result);
    }

    /**
     *
     * @param p
     * @return Squared distance between tow points
     */

    public double distanceSquared(Point p){
        double u1 =Math.abs(_xyz._d1-p._xyz._d1);
        double u2 =Math.abs(_xyz._d2-p._xyz._d2);
        double u3 =Math.abs(_xyz._d3-p._xyz._d3);

        return u1 * u1 + u2 * u2 + u3 * u3;
    }

    /**
     *
     * @param p
     * @return  distance between tow points
     */
    public double distance(Point p){
        return Math.sqrt(this.distanceSquared(p));
    }
}
