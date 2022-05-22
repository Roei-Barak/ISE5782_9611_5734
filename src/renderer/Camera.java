package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.Objects;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 *  camera class
 *
 * @author Michale & Roi
 */
public class Camera {

    private static Vector vRight;
    private static Vector vTo;
    private static Vector vUp;
    private static Point p0;
    private static double distance;
    private static int width;
    private static int height;

    /**
     * private default constructor for camera by the builder camera
     *
     * @param builder camera
     */
    private Camera(BuilderCamera builder) {
        p0 = builder._p0;
        vTo = builder._vTo;
        vUp = builder._vUp;
        vRight = builder._vRight;
        height = (int) builder._height;
        width = (int) builder._width;
        distance = builder._distance;
    }

    /**
     * Builder Class for Camera
     */
    public static class BuilderCamera {
        //point's location of the VP
        final private Point _p0;

        //vectors for the VP's direction
        final private Vector _vTo;
        final private Vector _vUp;
        final private Vector _vRight;

        //camera's distance
        private double _distance = 10;

        //camera's width
        private double _width = 1;

        //camera's height
        private double _height = 1;
        private double distance;

        //setter distance
        public BuilderCamera setDistance(double distance) {
            _distance = distance;
            return this;
        }


        //setter view plane's width
        public BuilderCamera setViewPlaneWidth(double width) {
            _width = width;
            return this;
        }

        //setter view plane's height
        public BuilderCamera setViewPlaneHeight(double height) {
            _height = height;
            return this;
        }

        //camera build default constructor
        public Camera build() {
            Camera camera = new Camera(this);
            return camera;
        }

        //camera build constructor
        public BuilderCamera(Point p0, Vector vTo, Vector vUp) {
            _p0 = p0;

            //check if the 2 vectors are orthogonal
            if (!isZero(vTo.dotProduct(vUp))) {
                throw new IllegalArgumentException("vto and vup are not orthogonal");
            }

            _vTo = vTo.normalize();
            _vUp = vUp.normalize();

            _vRight = _vTo.crossProduct(_vUp);

        }
//    // counstructor
//    public Camera (Point p0, Vector vto, Vector vup){
//        // throw error if not orthogonal
//
//        if(!isZero(vto.dotProduct(vup))){
//            throw new IllegalArgumentException("vup and vto are not orthogonal");
//        }
//
//        this.p0 = p0;
//
////        normalize the vectors
//        this.vTo = vto.normalize();
//        this.vUp = vup.normalize();
//        this.vRight = vTo.crossProduct(vUp).normalize();
//    }


    public Camera setVPDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public Camera setVPSize(int w, int h) {

        this.width = w;
        this.height = h;
        return this;
    }

        /**
         * source: course presentation page 27
         *
         * @param nX
         * @param nY
         * @param j
         * @param i
         * @return Ray
         */

        public Ray constructRay(int nX, int nY, int j, int i) { // name was: constructRayThroughPixel

//        ratio:
            double rX = alignZero(width / nX);
            double rY = alignZero(height / nY);
//       center

            Point pc = p0.add(vTo.scale(distance));

            double yI = alignZero((((nY - 1) / 2d) - i) * rY);
            double xJ = alignZero((j - ((nX - 1) / 2d)) * rX);

            Point pIJ = pc;
            if (xJ != 0)
                pIJ = pIJ.add(vRight.scale(xJ));
            if (yI != 0)
                pIJ = pIJ.add(vUp.scale(yI));

            return new Ray(p0, pIJ.subtract(p0));
        }

        /**
         * An override to check if two cameras positioned in the same location with the
         * same directions in vectors.
         *
         * @param obj - An object to compare to this camera.
         * @return True if: same camera or same fields. else, false.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Camera)) {
                return false;
            }
            Camera camera = (Camera) obj;
            return p0.equals(camera.p0) && vTo.equals(camera.vTo) && vUp.equals(camera.vUp)
                    && vRight.equals(camera.vRight) && width == camera.width && height == camera.height
                    && distance == camera.distance;
        }
    }
}
