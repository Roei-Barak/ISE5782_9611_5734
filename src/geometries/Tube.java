package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 *
 * @author Michael and Roi
 */

public class Tube extends Geometry {
    final double radius;
    final Ray axisRay;

    public Tube(double rd, Ray r){
        radius=rd;
        axisRay = new Ray(r.getP0(),r.getDir());
    }

    @Override
    public Vector getNormal(Point point) {
        Point p = axisRay.getP0();
        Vector v=axisRay.getDir();

        Vector tmp = point.subtract(p);
        double num = v.dotProduct(tmp);
        Point p2 = p.add(v.scale(num));
        if (p.equals(p2)) {
            throw new IllegalArgumentException("point cannot be on the tube axis");
        }
        Vector norm = point.subtract(p2).normalize();
        return norm;

    }
    /***
     * implementation of findIntersections from Geometry
     * @param ray - ray pointing towards the graphic object
     * @return Intersections between the ray and the geometry.
     */

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        double nv = axisRay.getDir().dotProduct(ray.getDir());
        if (isZero(nv) || ray.getP0() == axisRay.getP0()){
            return null;
        }
        Vector vec = axisRay.getP0().subtract(ray.getP0());
        double nQMinusP0 = axisRay.getDir().dotProduct(vec);
        double t  = alignZero(nQMinusP0 / nv);
        if (t > 0 ){
            return List.of(new GeoPoint(this,ray.getPoint(t)));
        }
        return null;
    }
}
