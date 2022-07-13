package lighting;

import primitives.Color;
import primitives.Double3;

/**
 * ambient light for all graghic objects
 */

/**
 *
 * @author Michael and Roi
 */
public class AmbientLight extends Light {

    /**
     * primary constractor
     * @param Ia basic intensity light
     * @param Ka attention
     */

    public AmbientLight(Color Ia, Double3 Ka) {
        //Ip = Ia* Ka
        super(Ia.scale(Ka));
    }

    /**
     * default constractor
     */
    public AmbientLight() {
        super(Color.BLACK);
    }
}
