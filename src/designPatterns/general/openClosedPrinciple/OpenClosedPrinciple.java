package designPatterns.general.openClosedPrinciple;

class Rectangle implements Shape {
    public double length;
    public double width;

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Circle implements Shape {
    public double radius;

    @Override
    public double calculateArea() {
        return (22.0 / 7.0) * radius * radius;
    }
}

class AreaCalculator {
    public double calculateShapeArea(Shape shape) {
        return shape.calculateArea();
    }
}

interface Shape {
    public double calculateArea();
}

/**
 * A class should be open for extension and
 * closed for modifications
 */
public class OpenClosedPrinciple {
    public static void main(String[] args) {

    }
}