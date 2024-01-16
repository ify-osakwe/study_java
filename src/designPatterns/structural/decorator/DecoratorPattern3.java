package designPatterns.structural.decorator;

interface ShapeT {
    void draw();
}

class RectangleT implements ShapeT {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class CircleT implements ShapeT {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}


abstract class ShapeDecoratorT implements ShapeT {
    protected ShapeT decoratedShape;

    public ShapeDecoratorT(ShapeT decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecoratorT {

    public RedShapeDecorator(ShapeT decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(ShapeT decoratedShape) {
        System.out.println("Border Color: Red");
    }
}


public class DecoratorPattern3 {
    public static void main(String[] args) {
        ShapeT circle = new CircleT();
        ShapeT redCircle = new RedShapeDecorator(new CircleT());
        ShapeT redRectangle = new RedShapeDecorator(new RectangleT());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
