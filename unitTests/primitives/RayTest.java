package primitives;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class RayTest {

    @Test
    void testFindClosestPoint()
    {

        // =============== Boundary Values Tests ==================

        // empty linked list
        List<Point> pointList=new LinkedList<>();
        Ray ray=new Ray(new Point(0, 0, 1), new Vector(0, 0, 1));
        assertNull(ray.findClosestPoint(pointList)," Error findClosestPoint doesn't work properly");


        pointList.add(new Point(1,1,1));
        pointList.add(new Point (1,2,3));
        pointList.add(new Point(2,3,4));

        //case 1: closest point is't first point
        assertEquals(new Point(1,1,1),ray.findClosestPoint(pointList),"Error findClosestPoint doesn't work properly");

        List<Point> pointList2=new LinkedList<>();
        pointList2.add(new Point (1,2,3));
        pointList2.add(new Point(2,3,4));
        pointList2.add(new Point(1,1,1));

        //case 2 : closest point is last point

        assertEquals(new Point(1,1,1),ray.findClosestPoint(pointList2),"Error findClosestPoint doesn't work properly");

        // ============ Equivalence Partitions Test ==============

        List<Point> pointList3=new LinkedList<>();
        pointList3.add(new Point (1,2,3));
        pointList3.add(new Point(1,1,1));
        pointList3.add(new Point(2,3,4));

        //case 3: closest point is the mid point

        assertEquals(new Point(1,1,1),ray.findClosestPoint(pointList3),"Error findClosestPoint doesn't work properly");


    }
}