package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;


public abstract class RayTracerBase {
   // protected field Scene
    protected Scene scene;
    //contructora
    public RayTracerBase(Scene scene1){this.scene= scene1;}

    public abstract Color traceRay(Ray ray);



}
