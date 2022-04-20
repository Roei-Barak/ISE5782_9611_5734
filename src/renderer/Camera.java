package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

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
            throw new IllegalArgumentException("vup and vt0 are not orthogonal");
        }
        this.p0 = p0;
        this.vTo = vto.normalize();
        this.vUp = vup.normalize();
        this.vRight = vTo.crossProduct(vUp);
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
    public Ray constructRay(int nX, int nY, int j, int i) {

        //ratio:

        double Ry  = (double) height / nY;
        double Rx  = (double) width / nX;

        Point Pc = p0.add(vTo.scale(distance)); // image center

        Point Pij = Pc;

        //pixel center:

        double Xj = (j - ((nX - 1) / 2d)) * Rx;
        double Yi = -(i - ((nY - 1) / 2d)) * Ry;


      if (!isZero(Xj)) Pij = Pij.add(vRight.scale(Xj));
      if (!isZero(Yi)) Pij = Pij.add(vUp.scale(Yi));

      return (new Ray (p0, Pij.subtract(p0)));

    }


}
