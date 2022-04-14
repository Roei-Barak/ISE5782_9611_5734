package geometries;
import geometries.*;
import primitives.*;

import java.util.List;

/**
 * Intersectable interface input: ray, output: List of Intersection points
 */
public interface Intersectable {

    public List<Point> findIntsersections(Ray ray);
}
