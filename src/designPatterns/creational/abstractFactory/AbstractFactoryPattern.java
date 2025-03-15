package designPatterns.creational.abstractFactory;

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw method");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw method");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw method");
    }
}

interface Color {
    void fill();
}

class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill method");
    }
}

class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill method");
    }
}

class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill method");
    }
}

abstract class AbstractFactory {
    abstract Color getColor(String colorType);

    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory {

    @Override
    Color getColor(String colorType) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase(StringAsset.shapeCircle)) {
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase(StringAsset.shapeRectangle)) {
            return new Rectangle();
        }
        if (shapeType.equalsIgnoreCase(StringAsset.shapeSquare)) {
            return new Square();
        }
        return null;
    }
}

class ColorFactory extends AbstractFactory {

    @Override
    Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase(StringAsset.blueColor)) {
            return new Blue();
        }
        if (colorType.equalsIgnoreCase(StringAsset.redColor)) {
            return new Red();
        }
        if (colorType.equalsIgnoreCase(StringAsset.greenColor)) {
            return new Green();
        }
        return null;
    }

    @Override
    Shape getShape(String shapeType) {
        return null;
    }
}

class FactoryProducer {
    static  AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase(StringAsset.factoryColor)) {
            return new ColorFactory();
        }
        if (choice.equalsIgnoreCase(StringAsset.factoryShape)) {
            return new ShapeFactory();
        }
        return null;
    }
}

abstract class StringAsset {
    static final String shapeCircle = "Circle";
    static final String shapeSquare = "Square";
    static final String shapeRectangle = "Rectangle";
    static final String redColor = "Red";
    static final String greenColor = "Green";
    static final String blueColor = "Blue";
    static final String factoryShape = "SHAPE";
    static final String factoryColor = "COLOR";
}

/**
 * <p>
 * This pattern provides an interface for creating families of
 * related or dependent objects without specifying their concrete classes.
 * Think of it as a "super factory that creates other factories"
 * </p>
 * <p>
 * Factory Pattern relies on inheritance. Object creation is delegated to subclasses,
 * which implement the factory method to create objects. Abstract Factory Pattern relies on
 * object composition. Object creation is implemented in methods exposed in the factory interface.
 * </p>
 * <p>
 * The intent of Factory Pattern is to allow a class to defer instantiation to its subclasses.
 * The intent of Abstract Factory Pattern is to create families of related objects without having
 * to depend on their concrete classes.
 * </p>
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(StringAsset.factoryShape);
        AbstractFactory colorFactory = FactoryProducer.getFactory(StringAsset.factoryColor);

        Shape shape = shapeFactory.getShape(StringAsset.shapeCircle);
        shape.draw();
        Shape shape1 = shapeFactory.getShape(StringAsset.shapeRectangle);
        shape1.draw();

    }
}
