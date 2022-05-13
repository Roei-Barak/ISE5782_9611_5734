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

    private Vector vRight;
    private Vector vTo;
    private Vector vUp;
    private Point p0;
    private double distance;
    private int width;
    private int height;


    // counstructor
    public Camera (Point p0, Vector vto, Vector vup){
        // throw error if not orthogonal

        if(!isZero(vto.dotProduct(vup))){
            throw new IllegalArgumentException("vup and vto are not orthogonal");
        }

        this.p0 = p0;

//        normalyze the vectors
        this.vTo = vto.normalize();
        this.vUp = vup.normalize();
        this.vRight = vTo.crossProduct(vUp).normalize();
    }


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
