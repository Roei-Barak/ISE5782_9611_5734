package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.MissingResourceException;
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
    private ImageWriter imageWriter;
    private RayTracer rayTracer;


    // counstructor
    public Camera (Point p0, Vector vto, Vector vup){
        // throw error if not orthogonal

        if(!isZero(vto.dotProduct(vup))){
            throw new IllegalArgumentException("vUp and vTo are not orthogonal");
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

        //    ratio:Pixel width & height
        double rX = (double)(width / nX);
        double rY = (double)(height / nY);
        //    Image center

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

    public Vector getvRight() {
        return vRight;
    }

    public Vector getvTo() {
        return vTo;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Point getP0() {
        return p0;
    }

    public double getDistance() {
        return distance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }

    public Camera setRayTracer(RayTracer rayTracer) {
        this.rayTracer = rayTracer;
        return this;
    }

    public void renderImage() {
        //to do
    }

    private Color castRay(int nX, int nY, int j, int i) {
        Ray ray = constructRay(nX, nY, j, i);
        primitives.Color pixelColor = rayTracer.traceRay(ray);
        return pixelColor;
    }

    public void writeToImage() {
        imageWriter.writeToImage();
    }

    public void printGrid(int interval, Color color) {
        for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                if (i % 50 == 0 || j % 50 == 0) {
                    imageWriter.writePixel(i, j, color);
                }
            }
        }
    }
}
