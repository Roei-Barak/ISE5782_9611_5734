/**
 * Plane class
 * Is represented by a point and normal
 * @author Michael & Roi
 */
package geometries;
import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.isZero;

public class Plane extends Geometry {
    final private Point _q0;
    final  private Vector _normal;

    public Plane(Point p1, Point p2, Point p3){

        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1))
            throw new IllegalArgumentException("Two of the points are the same point");

        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);

        try{
            Vector cross = v1.crossProduct(v2);

            _q0 = p2;
            _normal = cross.normalize();
        }
        catch (Exception e){
            throw new IllegalArgumentException("The points are on the same line");
        }
    }


    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        // In case there are zeroes in denominator and numerator
        // For example when ray is parallel to the plane
        if (ray.getP0().equals(_q0) || isZero(this._normal.dotProduct(ray.getDir()))
                || isZero(this._normal.dotProduct(_q0.subtract(ray.getP0()))))
            return null;

        double t = (this._normal.dotProduct(_q0.subtract(ray.getP0()))) / (this._normal.dotProduct(ray.getDir()));
        if (t < 0) // In case there is no intersection with the plane return null
            return null;

        //In case there is intersection with the plane return the point
        var p = ray.getPoint(t);
        LinkedList<GeoPoint> result = new LinkedList<GeoPoint>();

        result.add(new GeoPoint(this,p)) ;
        return result;
    }

    public Plane(Point p0, Vector normal) {
        _q0 = p0;
        _normal = normal.normalize();
    }



    @Override
    public String toString() {
        return "Plane{" +
                "_q0=" + _q0 +
                ", _normal=" + _normal +
                '}';
    }

    //public Vector get_normal() {
    //return _normal;
    //}

    @Override
    public Vector getNormal(Point p)
    {
        return _normal;
    }
    public Vector getNormal() {return _normal;}


}
