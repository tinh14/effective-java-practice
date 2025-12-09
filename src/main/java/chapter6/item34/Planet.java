package chapter6.item34;

public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass; // kg -> kilograms
    private final double radius; // m -> meters
    private final double surfaceGravity; // m / s^2 -> meters per second squared

    // Gravitational constant
    private static final double G = 6.67300E-11; // m^3 / (kg * s^2) -> meters cubed per kilogram per second squared

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surfaceGravity() { return surfaceGravity; }
    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }

    public static void main(String[] args) {
        System.out.println(Planet.EARTH.surfaceGravity() + " m/s²");
        System.out.println(Planet.MERCURY.surfaceGravity() + " m/s²");
    }
}
