package primitives;

public class Vector extends Point {
    /**
     * constructors
     *
     * @param xyz
     */
    public Vector(Double3 xyz) {
        super(xyz);
        if (_xyz.equals((Double3.ZERO))) {
            throw new IllegalArgumentException("Vector (0,0,0) not valid");
        }
    }

    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO)) {
            throw new IllegalArgumentException("Vector (0,0,0) not valid");
        }
    }

    /**
     * toString
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Vector" + _xyz;
    }

    /**
     * length func
     *
     * @return the length of the vector
     */

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;
        double u3 = _xyz._d3;

        return u1 * u1 + u2 * u2 + u3 * u3;
    }

    /**
     * dot product between two vectors (scalar product) *
     *
     * @param vector the right vector of U. V
     * @return scalar value of dot product
     * @link https://chepusht.mathcs.wilkes.edu/DotVsCrossProducts.pdf
     */
    public double dotProduct(Vector vector) {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;
        double u3 = _xyz._d3;

        double v1 = vector._xyz._d1;
        double v2 = vector._xyz._d2;
        double v3 = vector._xyz._d3;

        return (u1 * v1 + u2 * v2 + u3 * v3);
    }

    /**
     * @param number
     * @return new scaled vector
     */

    public Vector scale(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Zero vector not allowed");
        }
        return new Vector(this._xyz._d1 * number, this._xyz._d2 * number, this._xyz._d3 * number);
    }

    /**
     * @param vector the right vector of UxV
     * @return vector according to right-hand role
     * @link https://chepusht.mathcs.wilkes.edu/DotVsCrossProducts.pdf
     */
    public Vector crossProduct(Vector vector) {
        double u1 = _xyz._d1;
        double u2 = _xyz._d2;
        double u3 = _xyz._d3;

        double v1 = vector._xyz._d1;
        double v2 = vector._xyz._d2;
        double v3 = vector._xyz._d3;

        return new Vector((u2 * v3 - v2 * u3), -(u1 * v3 - v1 * u3), (u1 * v2 - v1 * u2));
    }

    /**
     * @return new normalize Vector
     */
    public Vector normalize() {
        double len = length();

        return new Vector((_xyz.reduce(len)));
    }

    /**
     * @param vector
     * @return new vector resulting the adding func
     */

    public Vector add(Vector vector) {
        return new Vector(_xyz.add(vector._xyz));
    }

}



