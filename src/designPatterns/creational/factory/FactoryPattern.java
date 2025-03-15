package designPatterns.creational.factory;

interface Animal {
    void walk();

    void eat();
}

class Duck implements Animal {

    @Override
    public void walk() {
        System.out.println("Duck is walking");
    }

    @Override
    public void eat() {
        System.out.println("Duck is eating");
    }
}

class Tiger implements Animal {

    @Override
    public void walk() {
        System.out.println("Tiger is walking");
    }

    @Override
    public void eat() {
        System.out.println("Tiger is eating");
    }
}

abstract class AnimalType {
    static final String duck = "duck";
    static final String tiger = "tiger";
}

class AnimalFactory {
    Animal getAnimalType(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase(AnimalType.duck)) {
            return new Duck();
        } else if (type.equalsIgnoreCase(AnimalType.tiger)) {
            return new Tiger();
        }
        return null;
    }
}

/**
 * FactoryPattern is used when
 * - a class cannot anticipate the class of objects it must create
 * - a class wants its subclasses to specify the object it creates
 * Examples in JDK
 * - Calendar, ResourceBundle, NumberFormat : getInstance() method
 * - valueOf() method : Boolean, Integer
 * - SAXParserFactory
 */
public class FactoryPattern {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal animal = animalFactory.getAnimalType(AnimalType.duck);
        animal.eat();
        animal.walk();

        Animal animal1 = animalFactory.getAnimalType(AnimalType.tiger);
        animal1.eat();
        animal1.walk();
    }
}
