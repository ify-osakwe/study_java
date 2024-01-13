package designPatterns.creational.builder;

interface BuilderInterface {
    void buildBody();

    void insertWheels();

    void addHeadlights();

    ProductX getVehicle();
}

class Car implements BuilderInterface {
    private final ProductX product = new ProductX();

    @Override
    public void buildBody() {
        product.add("This is body of a car");
    }

    @Override
    public void insertWheels() {
        product.add("4 wheels are added");
    }

    @Override
    public void addHeadlights() {
        product.add("2 headlights are added");
    }

    @Override
    public ProductX getVehicle() {
        return product;
    }
}

class MotorCycle implements BuilderInterface {
    private final ProductX product = new ProductX();

    @Override
    public void buildBody() {
        product.add("This is a body of a motorcycle");
    }

    @Override
    public void insertWheels() {
        product.add("2 wheels are added");
    }

    @Override
    public void addHeadlights() {
        product.add("1 headlights is added");
    }

    @Override
    public ProductX getVehicle() {
        return product;
    }
}


/**
 * <p> Example of builder pattern - java.lang.StringBuilder#append()
 *
 * <p> Use the builder pattern when (1) the algorithm for creating a complex object should
 * be independent of the parts that make up the object and how they are assembled.
 * (2) the construction process must allow different representations for the object
 * that is constructed.
 *
 * <p> Do not use builder pattern if you want a mutable object - an object which can be modified
 * after the creational process is over.
 */
public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println("***Builder Pattern Demo***\n");

        DirectorX directorX = new DirectorX();
        BuilderInterface carBuilder = new Car();
        BuilderInterface motorBuilder = new MotorCycle();

        directorX.construct(carBuilder);
        ProductX productX = carBuilder.getVehicle();
        productX.show();

        directorX.construct(motorBuilder);
        ProductX productX1 = motorBuilder.getVehicle();
        productX1.show();
    }
}
