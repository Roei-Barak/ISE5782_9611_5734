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
        this.xyz = xyz;
    }

    public final Double3 xyz;

    public Point(double x, double y, double z) {
        xyz = new Double3(x,y,z);
    }

    public Double3 getXyz() {
        return xyz;
    }

    public double getX(){
        return this.xyz.d1;
    }
    public double getY(){
        return this.xyz.d2;
    }
    public double getZ(){
        return this.xyz.d3;
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
        return xyz.equals(point.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xyz);
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Point " + xyz;
    }

    /**
     *
     * @param vector
     * @return new point: point+vector
     */
    public Point add(Vector vector) {
        return new Point(xyz.add(vector.xyz));
    }

    /**
     *
     * @param point
     * @return new vector
     */
    public Vector subtract(Point point) {
        Double3 result = xyz.subtract(point.xyz);
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
        double u1 =Math.abs(xyz.d1 -p.xyz.d1);
        double u2 =Math.abs(xyz.d2 -p.xyz.d2);
        double u3 =Math.abs(xyz.d3 -p.xyz.d3);

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
