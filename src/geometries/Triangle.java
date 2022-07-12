package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.isZero;

/**
 *
 * @author Michael and Roi
 */
public class Triangle extends Polygon {
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }
    @Override
    protected  List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<GeoPoint> tentativeIntersections = plane.findGeoIntersectionsHelper(ray);
        if (tentativeIntersections == null){
            return null;
        }

       //algorithm to test if given point P we got from plane findIntersctions
       //is inside the triangle
        Point p0 = ray.getP0();
        Vector v = ray.getDir();
        Vector v1 = vertices.get(0).subtract(p0);
        Vector v2 = vertices.get(1).subtract(p0);
        Vector v3 = vertices.get(2).subtract(p0);
        Vector[] crossVectors = {v1.crossProduct(v2).normalize(),
                                 v2.crossProduct(v3).normalize(),
                                 v3.crossProduct(v1).normalize()};
        int numOfPositiveNUmbers = 0;
        for (Vector vector : crossVectors){
            double vn = v.dotProduct(vector);
            if (isZero(vn)){
                return null;
            }
            if (vn > 0){
                numOfPositiveNUmbers++;
            }
        }
        //if NUmOfPositiveNumber isn't 0 or 3 it'smean ther is at least one number with odd sign
        if (numOfPositiveNUmbers != 0 && numOfPositiveNUmbers != 3){
            return null;
        }
        Point intersectPoint = tentativeIntersections.get(0).point;
        return List.of(new GeoPoint(this,intersectPoint));

    }
//    @Override
//    public  List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
//        List<Vector> lst = new ArrayList<Vector>();
//
//        Point pr = ray.getP0();
//        Vector v = ray.getDir();
//
//        for (Point p : super.vertices) {
//            Point pHelp = p.subtract(pr);
//            lst.add(new Vector(pHelp.get_xyz()));
//        }
//        //ask: if someone is vector 0? what happened?--------------------------------------------
//        Vector n1 = lst.get(0).crossProduct(lst.get(1)).normalize();
//        Vector n2 = lst.get(1).crossProduct(lst.get(2)).normalize();
//        Vector n3 = lst.get(2).crossProduct(lst.get(0)).normalize();
//
//        double d1 = v.dotProduct(n1);
//        double d2 = v.dotProduct(n2);
//        double d3 = v.dotProduct(n3);
//
//        if (isZero(d1) || isZero(d2) || isZero(d3)) {
//            return null;
//        }
//
//        //check if all the signs are same
//        if (!(d1 > 0 && d2 > 0 && d3 > 0 || d1 < 0 && d2 < 0 && d3 < 0)) {
//            return null;
//        }
//        return plane.findIntersections(ray);
//    }

    /***
     * implementation of findIntersections from Geometry
     * @param ray - ray pointing towards the graphic object
     * @return Intersections between the ray and the geometry.
     */

}


