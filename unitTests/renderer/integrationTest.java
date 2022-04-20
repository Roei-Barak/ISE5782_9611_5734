//package renderer;
//
//import geometries.Sphere;
//import org.junit.jupiter.api.Test;
//import primitives.Point;
//import primitives.Ray;
//import primitives.Vector;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * Testing Camera Class
// *
// * @author Dan
// *
// */
//class integrationTest {
//
//	/**
//	 * Test methods for
//	 * integration of camera, sphere, plane, triangle.
//	 */
//
//	@Test
//	public void testCameraAndSphere() {
//		// setup constants
//		double distance = 1d;
//		double vpWidth = 3d;
//		double vpHeight = 3d;
//
//		// TC01: only center ray (pixel #5 intersect the sphere).
//		Sphere sphere = new Sphere(new Point(0, 0, -3), 1);
//		Vector camVTo = new Vector(0, 0, -1);
//		Vector camVUp = new Vector(0, 1, 0);
//		Camera camera = new Camera(Point.ZERO, camVTo, camVUp);
//		camera.setVPDistance(distance);
//		camera.setVPSize(vpHeight, vpWidth);
//
//		int actualValue = findAllIntersections(camera, sphere);
//		assertEquals(2, actualValue, "TC01: The Center Ray should intersect the sphere 2 times.");
//
//		// TC02: all ray from camera through View Panel intersect twice.
//		sphere = new Sphere(2.5, new Point(0, 0, -2.5));
//		camera = new Camera(new Point(0, 0, 0.5), camVTo, camVUp);
//		camera.setVPDistance(distance);
//		camera.setVPSize(vpHeight, vpWidth);
//
//		actualValue = findAllIntersections(camera, sphere);
//		assertEquals(18, actualValue, "TC02: All Rays should intersect the sphere 2 times.");
//
//		// TC03: all Ray but Corner Rays intersect the Sphere.
//		sphere = new Sphere(2, new Point(0, 0, -2));
//
//		actualValue = findAllIntersections(camera, sphere);
//		assertEquals(10, actualValue, "TC03: The non corner Rays should intersect the sphere 2 times.");
//
//		// TC04: camera inside Sphere so only 9 intersection (1 for each pixel).
//		sphere = new Sphere(4, new Point(0, 0, -2));
//
//		actualValue = findAllIntersections(camera, sphere);
//		assertEquals(9, actualValue, "TC04: All Rays should intersect the sphere one time only.");
//
//		// TC05: no intersections because camera is after the Sphere.
//		sphere = new Sphere(0.5, new Point(0, 0, 1));
//
//		actualValue = findAllIntersections(camera, sphere);
//		assertEquals(0, actualValue, "TC05: All rays should not intersect the sphere.");
//
//	}
//
//
//
//}
