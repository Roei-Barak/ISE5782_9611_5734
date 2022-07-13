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

    /**
     * Constructor that get a scene
     * @param scene
     */
    public RayTracer(Scene scene){
        this.scene = scene;
    }

    /**
     * trace the ray and calculate the rey's intersection point color
     * and any other object (or the background if the rey's intersection point
     * doesn't exist)
     *
     * @param ray
     * @return
     */
    abstract Color traceRay(Ray ray);
}