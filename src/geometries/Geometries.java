package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Geometries extends Intersectable {

    private List<Intersectable> shapes = null;

    public Geometries() {
        shapes = new LinkedList<>();
    }

    public Geometries(Intersectable... geometries) {
        this();
        add(geometries);
    }

    public void add(Intersectable... geometries) {
        if (shapes == null) {
            throw new IllegalStateException("list not created");
        }
        for (Intersectable i : geometries)
            shapes.add(i);
    }

    @Override
       protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        if (shapes.isEmpty()){
            return null;
        }
        List<GeoPoint> intersections = null;
        for (Intersectable intersectable : shapes) {
            List<GeoPoint> pointList = intersectable.findGeoIntersections(ray);
            if (pointList != null) {
                if (intersections == null) {
                    intersections = new LinkedList<>(pointList);
                }
                intersections.addAll(pointList);
            }
        }
        return intersections;
    }

}
