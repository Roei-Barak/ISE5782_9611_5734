package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Geometry interface, for getNormal functions to geometries
 */
public interface Geometry {
    Vector getNormal(Point point);
}
