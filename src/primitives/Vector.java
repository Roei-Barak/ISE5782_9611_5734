package primitives;

public class Vector extends Point{

    public Vector(Double3 xyz) {
        super(xyz);
        if (_xyz.equals((Double3.ZERO)){
            throw new IllegalArgumentException("Vector (0,0,0) not valid");
        }
    }

    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO){
            throw new IllegalArgumentException("Vector (0,0,0) not valid");
        }
    }

    @Override
    public String toString() {
        return "Vector" + _xyz;
    }

    private double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        double u1 =_xyz._d1;
        double u2 =_xyz._d2;
        double u3 =_xyz._d3;
        return _xyz.product(_xyz);
    }

    public double dotProduct(Vector vector) {
        return 0;
    }

    public Vector crossProduct(Vector vector) {

    }

    public Vector normalize() {
        double len = length();

        return new Vector((_xyz.reduce(len)));
    }

}
