package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for {@link geometries.Plane class}
 * @author Michael and Roi
 */



class PlaneTest {

    @Test
    void getNormal() {
        Point p1=new Point(1,1,1);
        Point p2=new Point(1,1,0);
        Point p3=new Point(1,0,1);
        Plane plane=new Plane (p1,p2,p3);
        assertEquals(plane.getNormal(),new Vector(-1,0,0),"ERROR:wrong value!");

        assertEquals(1,plane.getNormal().length(),"ERROR: the length isn't 1");

    }
}