package designPatterns.behavioural.templateMethod;

abstract class HouseTemplate {
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built");
    }

    private void buildFoundation() {
        System.out.println("Building foundation with cement, iron rods and sand");
    }

    private void buildWindows() {
        System.out.println("Building windows");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();
}

class WoodenHouse extends  HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building wooden walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("building wooden pillars");
    }
}

class GlassHouse extends  HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building glass walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("building glass pillars");
    }
}

/**
 * <p> Examples in JDK:
 * - non-abstract methods of java.io; InputStream, OutputStream, Reader, Writer
 * - non-abstract methods of java.util; AbstractList, AbstractSet, AbstractMap
 * -
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();

        System.out.println("*********");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
