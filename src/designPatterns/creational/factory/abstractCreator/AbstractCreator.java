package designPatterns.creational.factory.abstractCreator;

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

public class AbstractCreator {
    public static void main(String[] args) {
        Shape shape1 = new CircleFactory().getShape();
        shape1.draw();

        Shape shape2 = new RectangleFactory().getShape();
        shape2.draw();

        Shape shape3 = new SquareFactory().getShape();
        shape3.draw();
    }
}
