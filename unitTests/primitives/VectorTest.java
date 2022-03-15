package primitives;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;


/**
 * Unit tests for Cylinder
 * @author Michael and Roi
 */


class VectorTest {


    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(-2, -4, -6);
    Vector v3 = new Vector(0, 3, -2);

    void testConstructorNotZero()
    {
        assertThrows(IllegalArgumentException.class,()->{new Vector(0, 0, 0.0);},
                "Vector 0 should have thrown Exception");
    }
    /**
    test length
     */
    @Test
    void length() {
        assertTrue(isZero(new Vector(0, 3, 4).length() - 5));
    }

    /**
     * test length Squared
     */
    @Test
    void lengthSquared() {
        assertTrue(isZero(v1.lengthSquared()-14));
    }

    /**
     * testing method {@link Vector#dotProduct(Vector)}
     */

    @Test
    public void dotProductEP() {

        // ============ Equivalence Partitions Tests ==============
        // TCXX: Simple dotProduct test
        assertEquals(-28d,v1.dotProduct(v2),0.000001,"dotProduct Error");
        assertTrue(isZero(v1.dotProduct(v2) + 28));
    }

    @Test
    public void dotProductBVA() {
        // =============== Boundary Values Tests ==================
        // TCXX: dotProduct for orthogonal vectors
        assertEquals(0d, v1.dotProduct(v3),0.000001,"dotProduct for orthogonal Vectors != zero");
    }


    @Test
    void scale() {
    }

    /**
     * Test the length of cross-product is good
     */
    @Test
    void crossProduct1() {
        // ============ Equivalence Partitions Test ==============
        Vector vector = v1.crossProduct(v3);
        double vv1= vector.length();
        double vv2 = v1.length()*v3.length();
        assertEquals(vv2,
                vv2,
                0.000000000001,
                "ERROR: crossProduct() wrong result length");
    }


    /**
     * Test cross-product result orthogonality to its operands
     */
    @Test
    void crossProduct2() {
        // ============ Equivalence Partitions Test ==============
        Vector vr = v1.crossProduct(v3);
        assertTrue(isZero(vr.dotProduct(v1)), "crossProduct is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v2)), "crossProduct is not orthogonal to 2nd operand");
    }

    @Test
    /**
     * test ZERO-vector from cross-product of co-lines vectors
     */
    void crossProduct3() {
        // =============== Boundary Values Test ==================
        assertThrows(IllegalArgumentException.class,() -> { v1.crossProduct(v2);}
                ,"ERROR: cross-Product of parallel vectors didnt throw an exceptionn");
    }

    @Test
    void normalize() {

    }

    @Test
    void add() {
    }
}