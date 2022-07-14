package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;



/**
 * Unit tests for {@link geometries.Tube class}
 * @author Michael and Roi
 */




class TubeTest {
    /**
     * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Tube t = new Tube(new Ray(new Point(1, 0, 0), new Vector(0, 0, 1)), 1.0);
        Vector norm = t.getNormal(new Point(1, 1, 3));
        //make sure that the norm is normalize to the axis ray
        double res = norm.dotProduct(t.axisRay.getDir());
        assertEquals(0d, res, "normal is not orthogonal to the tube");
        //check that the normal is right
        assertEquals(new Vector(0, 1, 0), norm, "bad normalize in tube");
    }

    /**
     * Test method for {@link geometries.Tube#findIntersections(Ray ray)}.
     */
    @Test
    public void testfindIntersectionsRay() {


    }
}