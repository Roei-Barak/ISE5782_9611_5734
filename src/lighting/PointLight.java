package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class PointLight extends Light implements LightSource  {

    private Point position;
    private double kC = 1, kL = 0, kQ = 0;

    /***
     * Constructor
     * @param intensity
     */
    protected PointLight(Color intensity) {
        super(intensity);
    }

    /**
     * Get the intensity of the light at a point
     *
     * @param p origin of the light
     * @return the intensity
     */
    @Override
    public Color getIntensity(Point p) {
        return null;
    }

    /**
     * Get the direction of the light from a point
     *
     * @param p the point
     * @return the direction
     */
    @Override
    public Vector getL(Point p) {
        return null;
    }
}
