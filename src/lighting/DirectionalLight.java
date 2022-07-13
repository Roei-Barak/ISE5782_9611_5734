package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{
    private Vector direction;

    /***
     * Constructor
     * @param intensity
     */
    protected DirectionalLight(Color intensity, Vector dir) {
        super(intensity);
        this.direction = dir.normalize();
    }

    /**
     * Return the intensity light on point
     *
     * @param p the point on the object
     * @return the intensity
     */
    @Override
    public Color getIntensity(Point p) {
        return this.getIntensity();
    }
    /**
     * Return normalize direction vector from the light source to the object
     *
     * @param p the point on the object
     * @return normalize direction vector
     */
    @Override
    public Vector getL(Point p) {
        return this.direction.normalize();
    }
}
