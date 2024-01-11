package designPatterns.creational.factory.concreteCreator;

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method");
    }
}

abstract class ShapeType {
    static final String circle = "CIRCLE";
    static final String rectangle = "RECTANGLE";
    static final String square = "SQUARE";
}

class ShapeFactory {
    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        } else if (shapeType.equalsIgnoreCase(ShapeType.circle)) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase(ShapeType.rectangle)) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase(ShapeType.square)) {
            return new Square();
        }
        return null;
    }
}

/**
 * Most common implementation of the factory pattern.
 */
public class ConcreteCreator {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape(ShapeType.circle);
        shape1.draw();

        Shape shape2 = shapeFactory.getShape(ShapeType.rectangle);
        shape2.draw();

        Shape shape3 = shapeFactory.getShape(ShapeType.square);
        shape3.draw();
    }
}
