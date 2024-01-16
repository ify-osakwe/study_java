package designPatterns.structural.adapter;

class RectangleG {
    public double length;
    public double width;
}

class TriangleG {
    public double base;
    public double height;

    public TriangleG(double b, double h) {
        base = b;
        height = h;
    }
}

interface CalculatorInterface {
    public double getArea(RectangleG r);
}

class Calculator implements CalculatorInterface {
    RectangleG rectangle;

    @Override
    public double getArea(RectangleG r) {
        rectangle = r;
        return rectangle.length * rectangle.width;
    }
}

class CalculatorAdapter implements CalculatorInterface {

    Calculator calculator;
    TriangleG triangle;

    public CalculatorAdapter(TriangleG myTriangle) {
        triangle = myTriangle;
    }

    @Override
    public double getArea(RectangleG r) {
        calculator = new Calculator();
        RectangleG rectangle = new RectangleG();

        rectangle.length = triangle.base;
        rectangle.width = 0.5 * triangle.height;
        return calculator.getArea(rectangle);
    }
}

public class ObjectAdapterPattern2 {
    public static void main(String[] args) {
        TriangleG triangle = new TriangleG(20, 10);
        CalculatorInterface calculatorAdapter = new CalculatorAdapter(triangle);

        System.out.println("Area of Triangle is: " + calculatorAdapter.getArea(null));
    }
}
