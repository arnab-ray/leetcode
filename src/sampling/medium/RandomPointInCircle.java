package sampling.medium;

import java.util.Random;

public class RandomPointInCircle {

    private double x;
    private double y;
    private final double radius;
    private final Random random;

    public RandomPointInCircle(double radius, double x_center, double y_center) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.random = new Random();
    }

    public double[] randPoint() {
        double radians = random.nextDouble() * 2 * Math.PI;
        double radius = this.radius * Math.sqrt(random.nextDouble());

        double x = this.x + radius * Math.cos(radians);
        double y = this.y + radius * Math.sin(radians);
        return new double[] { x, y };
    }

}
