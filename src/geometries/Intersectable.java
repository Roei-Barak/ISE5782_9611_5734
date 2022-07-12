package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

/***
 * common interface for all graphic objects
 * that this intersect with a ray {@link primitives.Ray}
 */
public abstract class Intersectable {
    /***
     * find all intersections points {@link Point} that intersect with
     * a specific Ray {@link Ray}
     * @param ray - ray pointing towards the graphic object
     * @return immutable list of intersections  points {@link Point}
     */
    public static class GeoPoint{

        private final Geometry geometry;
        public final Point point;

        public GeoPoint(Geometry geometry, Point point){
            this.geometry = geometry;
            this.point = point;
        }
    }
    public final List<Point> findIntersections(Ray ray){
        List<GeoPoint> geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream()
                .map(gp -> gp.point)
                .toList();
    }
    public final List<GeoPoint> findGeoIntersections(Ray ray){
        return findGeoIntersectionsHelper(ray);
    }
    protected abstract  List<GeoPoint> findGeoIntersectionsHelper(Ray ray);
}
