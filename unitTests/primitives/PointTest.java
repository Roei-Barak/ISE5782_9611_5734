package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for point
 *
 * @author Michael and Roi
 */

class PointTest {

    @Test
    void testZeroVector() {
        assertThrows(IllegalArgumentException.class,()->new Vector(0,0,0),
                "should have throw Exception");
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
        fail("not working");
    }

    @Test
    void testToString() {
    }

    @Test
    void add() {
    }

    @Test
    void subtract() {
    }

    @Test
    void distanceSquared() {
    }

    @Test
    void distance() {
    }
}