package playground.bcs;

import java.util.Random;

public class ApproximatePi {
    public static void main(String[] args) {
        int n = 1000000; // Number of random points
        double piEstimate = approximatePi(n);
        System.out.println("Approximate value of Pi: " + piEstimate);
    }

    public static double approximatePi(int n) {
        Random random = new Random();
        int pointsInsideCircle = 0;

        for (int i = 0; i < n; i++) {
            double x = random.nextDouble(); // Generate random x between 0 and 1
            double y = random.nextDouble(); // Generate random y between 0 and 1

            // Calculate distance from origin
            double distance = Math.sqrt(x * x + y * y);

            // Check if the point lies inside the quarter circle
            if (distance <= 1) {
                pointsInsideCircle++;
            }
        }

        // Ratio of points inside circle to total points, multiplied by 4
        return 4.0 * pointsInsideCircle / n;
    }
}

