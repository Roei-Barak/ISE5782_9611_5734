package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

/**
 * class used to trace rays for the rendering engine
 */

public abstract class RayTracer {
    /***
     * scene to be rendered
     */
    protected Scene scene;

    /***
     * constructor for the ray tracer
     * @param scene to be intersected
     */

    public RayTracer(Scene scene) {this.scene = scene;}

    /**
     * the fanction get a ray and reyurn the color of the ray attach
     * @param ray
     * @return
     */
    abstract public Color traceRay(Ray ray);

    private Color calcColor(Point point) {
        return scene.ambient.getIntensity();
    }

}
