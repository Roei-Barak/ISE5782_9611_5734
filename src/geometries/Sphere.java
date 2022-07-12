package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.*;

import static primitives.Util.alignZero;

/**
 *
 * @author Michael and Roi
 */
public class Sphere extends Geometry {
    final Point center;
    final double radius;

    public Sphere(Point p, double r){
        center =new Point(p.get_xyz());
        radius= r;
    }

    @Override
    public Vector getNormal(Point p) {
        Point pn = p.subtract(center);
        Vector norm = new Vector(pn.get_xyz());
        return norm.normalize();
    }
    /***
     * implementation of findIntersections from Geometry
     * @param ray - ray pointing towards the graphic object
     * @return Intersections between the ray and the geometry.
     */
//    @Override
//    public List<Point> findIntersections(Ray ray) {
//
//        Point P0 = ray.getP0();
//        //check the cae that the point is on the center
//        if (P0.equals(center)) {
//            return List.of(center.add(ray.getDir().scale(radius)));
//        }
//
//        Vector u = this.center.subtract(P0);
//
//        double tm = ray.getDir().dotProduct(u);
//        double d = Math.sqrt(u.lengthSquared()-Math.pow(tm,2));
//        if (d>=radius)
//            return null;
//        double th = Math.sqrt(Math.pow(radius,2)-Math.pow(d,2));
//        double t1 = tm -th;
//        double t2 = tm +th;
//
//        if (t1<= 0 && t2<=0)
//            return null;
//
//        List<Point> lst=new ArrayList<Point>();
//        if (t1 >0)
//        {
//            Point cross_p = ray.getP0().add(ray.getDir().scale(t1));
//            lst.add(cross_p);
//        }
//
//        if (t2 >0)
//        {
//            Point cross_p = ray.getP0().add(ray.getDir().scale(t2));
//            lst.add(cross_p);
//        }
//
//        return lst;
//    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        double tM, d;
        try {
            Vector u = center.subtract(ray.getP0());
            tM = alignZero(ray.getDir().dotProduct(u));
            d = alignZero(Math.sqrt(u.lengthSquared() - tM * tM));
        } catch (IllegalArgumentException e) {
            tM = 0;
            d = 0;
        }
        if (d >= radius) {
            return null;
        }
        double tH = alignZero(Math.sqrt(radius * radius - d * d));
        double t1 = alignZero(tM + tH);
        double t2 = alignZero(tM - tH);

        if (t1 > 0 && t2 > 0) {
                return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        }
        if (t1 > 0) {
            return List.of(new GeoPoint(this, ray.getPoint(t1)));
        }
        if (t2 > 0) {
            return List.of(new GeoPoint(this, ray.getPoint(t2)));
        }
        List<Point> tentativeIntersections = new ArrayList<>();
        return null;
    }
}
