package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link geometries.Cylinder class}
 * @author Michael and Roi
 */

class CylinderTest {
        @Test
        void testGetNormal()
        {
            Cylinder c = new Cylinder(
                    new Ray(new Point(0, 0, 1), new Vector(0, 0, 1)),
                    2.0,
                    3);
            // test for point on first disk
            assertEquals(new Vector(0,0, 1), c.getNormal(new Point(0, 1, 1)));

            assertEquals(new Vector(0,1, 0), c.getNormal(new Point(0, 1, 3)));

        }
}