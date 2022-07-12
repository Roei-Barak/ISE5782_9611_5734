package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/***
 * interface for all graphic 3D objects that are
 * positioned in our 3D
 */
public abstract class Geometry extends Intersectable {

    /***
     * normal vector from a specific Point {@link Point}
     * @param point point outside the grophic shape
     * @return nomal vector {@link Vector}
     */
    protected Color emission = Color.BLACK;

    /***
     * Getter of color
     * @return the geometry's color
     */
    public Color getEmission() {
        return emission;
    }

    /***
     * Setter for emission
     *
     * @param emission
     * @return
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    public abstract Vector getNormal(Point point);
}