package designPatterns.structural.bridge;

abstract class Workshop {
    abstract public void work();
}

class Produce extends Workshop {
    @Override
    public void work() {
        System.out.println("Produced");
    }
}

class Assemble extends Workshop {
    @Override
    public void work() {
        System.out.println("Assembled");
    }
}

abstract class VehicleF {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected VehicleF(Workshop workshop1, Workshop workshop2) {
        this.workshop1 = workshop1;
        this.workshop2 = workshop2;
    }

    abstract public void manufacture();
}

class Car extends VehicleF {
    protected Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Car");
        workshop1.work();
        workshop2.work();
    }
}

class Bike extends VehicleF {
    protected Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2);
    }

    @Override
    public void manufacture() {
        System.out.println("Bike");
        workshop1.work();
        workshop2.work();
    }
}

/**
 * <p>Bridge pattern - separating the abstractions from the implementations.
 */
public class BridgePattern {
    public static void main(String[] args) {
        VehicleF vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();

        VehicleF vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();
    }
}
