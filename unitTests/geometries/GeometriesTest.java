package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for {@link geometries.Geometries class}
 * @author Michael and Roi
 */


class GeometriesTest {

    ArrayList<Geometries> geoms = new ArrayList<>();

    // geometries for the tests
    Sphere sphere1 = new Sphere(new Point(0,0,0), 4);
    Sphere sphere2 = new Sphere(new Point(8,0,0), 4);
    Sphere sphere3 = new Sphere(new Point(9,0,0), 4);


    //test add function

    @Test
    void add_geometries() {
        Geometries geometries = new Geometries();
        geometries.add_geometries(sphere1, sphere2);
        assertEquals(2, geometries.get_GeometriesList().size()); // test number of geometries
        assertEquals(sphere1, geometries.get_GeometriesList().get(0)); // test the addition of first geometry
        assertEquals(sphere2, geometries.get_GeometriesList().get(1));// test the addition of second geometry
    }

    @Test
    void findIntersections() {
        Ray ray = new Ray(new Point(-6,0,0), new Vector(1,0,0));


        //the 2 geometries doesnt have a point of contact
        Geometries geometries2 = new Geometries();
        geometries2.add_geometries(sphere1, sphere3);
        ArrayList<Geometry> expected2 = new ArrayList<>();
//        expected2.add(new Geometry(sphere1, new Point(-4,0,0)));//sphere1
//        expected2.add(new Geometry(sphere1, new Point(4,0,0)));//sphere1
//        expected2.add(new Geometry(sphere3, new Point(5,0,0)));//sphere3
//        expected2.add(new Geometry(sphere3, new Point(13,0,0)));//sphere3
//        ArrayList<Geometry> actual2 = geometries2.findIntersections(ray);
      //  assertEquals(expected2, actual2);




    }
}