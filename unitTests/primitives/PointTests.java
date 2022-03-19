package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for primitives.Point class
 * @author Michael and Roei
 */
public class PointTests {
    /**
     * Test method for {@link primitives.Point#add(Vector)}.
     */
    @Test
    public void testAdd() {
        Point p1 = new Point(1, 2, 3);
        assertEquals(p1.add(new Vector(1, 2, 3)),new Point(2, 4, 6),"ERROR: Point add Vector doesn't work");
    }
    /**
     * Test method for {@link primitives.Point#subtract(Point)}.
     */
    @Test
    void subtract() {
        Point p = new Point(1, 2, 3);
        assertEquals(new Vector(1, 2, 3),new Point(2, 4, 6).subtract(p),"ERROR: Point subtract Point doesn't work");

    }
    /**
     * Test method for {@link primitives.Point#distanceSquared(Point)}.
     */
    @Test
    void distanceSquared() {
        Point p1=new Point(1,2,3);
        Point p2=new Point(1,2,0);
        assertEquals(9,p1.distanceSquared(p2),"ERROR: distance squared doesn't work.");
    }
    /**
     * Test method for {@link primitives.Point#distance(Point)}.
     */
    @Test
    void distance() {
        Point p1=new Point(1,2,3);
        Point p2=new Point(1,2,0);
        assertEquals(3,p1.distance(p2),"ERROR: distance doesn't work.");

    }
}