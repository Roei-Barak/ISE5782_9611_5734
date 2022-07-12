package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;
import java.util.Objects;

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

    protected abstract  List<GeoPoint> findGeoIntersectionsHelper(Ray ray);

    public List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray);
    }

    public List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream().map(gp -> gp.point).toList();
    }


    public static class GeoPoint {

        public final Geometry geometry;
        public final Point point;

        /***
         * Constructor
         * @param geometry
         * @param point
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) && point.equals(geoPoint.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(geometry, point);
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }
}
