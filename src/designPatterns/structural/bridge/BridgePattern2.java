package designPatterns.structural.bridge;

interface ColorY {
    void fillWithColor(int border);
}

class RedColor implements ColorY {
    @Override
    public void fillWithColor(int border) {
        System.out.println("Red color with " + border + " inch border");
    }
}

class GreenColor implements ColorY {
    @Override
    public void fillWithColor(int border) {
        System.out.println("Green color with " + border + " inch border");
    }
}

abstract class ShapeJ {
    protected ColorY color;

    protected ShapeJ(ColorY color) {
        this.color = color;
    }

    abstract void drawShape(int border);

    abstract void modifyBorder(int border, int increment);
}

class TriangleJ extends ShapeJ {
    protected TriangleJ(ColorY color) {
        super(color);
    }

    // Implementer specific method
    @Override
    void drawShape(int border) {
        System.out.println("This Triangle is colored with ");
        color.fillWithColor(border);
    }

    // Abstraction specific method
    @Override
    void modifyBorder(int border, int increment) {
        System.out.println("\nNow we are changing the border length " + increment + " times.");
        border = border * increment;
        drawShape(border);
    }
}

class RectangleJ extends ShapeJ {
    protected RectangleJ(ColorY color) {
        super(color);
    }

    // Implementer specific method
    @Override
    void drawShape(int border) {
        System.out.println("This Rectangle is colored with ");
        color.fillWithColor(border);
    }

    // Abstraction specific method
    @Override
    void modifyBorder(int border, int increment) {
        System.out.println("\nNow we are changing the border length " + increment + " times.");
        border = border * increment;
        drawShape(border);
    }
}

public class BridgePattern2 {
    public static void main(String[] args) {
        System.out.println("\nColoring Triangle: ");
        ColorY green = new GreenColor();
        ShapeJ triangle = new TriangleJ(green);
        triangle.drawShape(20);
        triangle.modifyBorder(20, 3);

        System.out.println("\nColoring Rectangle: ");
        ColorY red = new RedColor();
        ShapeJ rectangle = new RectangleJ(red);
        rectangle.drawShape(50);
        rectangle.modifyBorder(50, 2);
    }
}
