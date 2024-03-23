package timBulchalka.codingExercise;

public class Exercise34 {
    public static void main(String[] args) {
        Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());

        carpet = new Carpet(1.5);
        floor = new Floor(5.4, 4.5);
        calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());
    }
}

// Floor class
class Floor {
    private final double width;
    private final double length;

    public Floor(double width, double length) {
        this.width = (width < 0) ? 0 : width;
        this.length = (length < 0) ? 0 : length;
    }

    public double getArea() {
        return width * length;
    }
}

// Carpet class
class Carpet {
    private final double cost;

    public Carpet(double cost) {
        this.cost = (cost < 0) ? 0 : cost;
    }

    public double getCost() {
        return cost;
    }
}

/**
 * record Carpet(double cost) {
 *     // Constructor with parameter
 *     Carpet(double cost) {
 *         // Set cost to 0 if less than 0
 *         this.cost = (cost < 0) ? 0 : cost;
 *     }
 * }
 */

// Calculator class
class Calculator {
    private final Floor floor;
    private final Carpet carpet;

    // Constructor with parameters
    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    // Method to calculate total cost
    public double getTotalCost() {
        return floor.getArea() * carpet.getCost();
    }
}
