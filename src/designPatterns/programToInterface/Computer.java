package designPatterns.programToInterface;

interface DisplayModule {
    public void display();
}

class Monitor implements DisplayModule {

    @Override
    public void display() {
        System.out.println("Display through monitor");
    }
}

class Projector implements DisplayModule {

    @Override
    public void display() {
        System.out.println("Display through projector");
    }
}

public class Computer {
    DisplayModule displayModule;

    public void setDisplayModule(DisplayModule displayModule) {
        this.displayModule = displayModule;
    }

    public void display() {
        displayModule.display();
    }

}
