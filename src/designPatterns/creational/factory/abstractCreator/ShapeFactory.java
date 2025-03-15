package designPatterns.creational.factory.abstractCreator;

public abstract class ShapeFactory {

    protected abstract Shape factoryMethod();

    public Shape getShape() {
        return factoryMethod();
    }
}

class RectangleFactory extends ShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Rectangle();
    }
}

class SquareFactory extends ShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Square();
    }
}

class CircleFactory extends ShapeFactory {

    @Override
    protected Shape factoryMethod() {
        return new Circle();
    }
}