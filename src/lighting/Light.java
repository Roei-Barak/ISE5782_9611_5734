package lighting;


import primitives.Color;

/**
 * Light abstract class
 */
abstract class Light {
    private Color intensity; //light intensity as color

    /***
     * Constructor
     * @param intensity
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /***
     * Getter
     * @return intensity
     */
    public Color getIntensity() {
        return intensity;
    }
}
