package timBuchalka.codingExercise;

public class Exercise40 {
    public static void main(String[] args) {
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }
}

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public String startEngine() {
        return "The " + this.name + " with " + this.cylinders + " cylinders engine is starting.";
    }

    public String accelerate() {
        return "The " + this.name + " is accelerating.";
    }

    public String brake() {
        return "The " + this.name + " is braking.";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The " + getClass().getSimpleName() + " with " + getCylinders() + " cylinders engine is starting.";
    }

    @Override
    public String accelerate() {
        return "The " + getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "The " + getClass().getSimpleName() + " is braking.";
    }
}

class Holden extends Car {
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The " + getClass().getSimpleName() + " with " + getCylinders() + " cylinders engine is starting.";
    }

    @Override
    public String accelerate() {
        return "The " + getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "The " + getClass().getSimpleName() + " is braking.";
    }
}

class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "The " + getClass().getSimpleName() + " with " + getCylinders() + " cylinders engine is starting.";
    }

    @Override
    public String accelerate() {
        return "The " + getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "The " + getClass().getSimpleName() + " is braking.";
    }
}

