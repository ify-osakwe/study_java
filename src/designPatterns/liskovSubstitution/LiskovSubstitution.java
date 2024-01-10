package designPatterns.liskovSubstitution;


import java.util.List;

abstract class Vehicle {
    abstract int getSpeed();

    abstract int getCubicCapacity();
}

class Car extends Vehicle {

    int getSpeed() {
        return 0;
    }

    int getCubicCapacity() {
        return 0;
    }

    boolean sHatchBack() {
        return true;
    }
}

class Bus extends Vehicle {
    int getSpeed() {
        return 1;
    }

    int getCubicCapacity() {
        return 1;
    }

    String getEmergencyExitLoc() {
        return "Exit";
    }
}

/**
 * A supertype and subtype can be swapped
 * without breaking things
 */
public class LiskovSubstitution {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        vehicle.getSpeed();
        vehicle = new Car();
        vehicle.getCubicCapacity();


    }
}
