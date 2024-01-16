package designPatterns.structural.decorator;

abstract class ComponentD {
    public abstract void doJob();
}

class ConcreteComponentD extends ComponentD {

    @Override
    public void doJob() {
        System.out.println("I am a concrete component - I am closed for modification");
    }
}

abstract class AbstractDecoratorD extends ComponentD {
    protected ComponentD component;

    public void setTheComponent(ComponentD component) {
        this.component = component;
    }

    @Override
    public void doJob() {
        if (component != null) component.doJob();
    }
}

class ConcreteDecoratorA extends AbstractDecoratorD {
    @Override
    public void doJob() {
        super.doJob();
        System.out.println("I am concrete decorator A");
    }
}

class ConcreteDecoratorB extends AbstractDecoratorD {
    @Override
    public void doJob() {
        super.doJob();
        System.out.println("I am concrete decorator B");
    }
}


/**
 * <p> The main principle of this pattern says that we cannot modify existing functionalities,
 * but we can extend them - open for extension but closed for modification. A decorator is used
 * to modify the functionality of an object at runtime.
 *
 * <p> Examples of decorator - classes in java.io packages; BufferedInputStream and LineNumberInputStream
 * both extend FilterInputStream.
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        ConcreteComponentD concreteComponent = new ConcreteComponentD();

        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        concreteDecoratorA.setTheComponent(concreteComponent);
        concreteDecoratorA.doJob();

        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
        concreteDecoratorB.setTheComponent(concreteDecoratorA);
        concreteDecoratorB.doJob();
    }
}
