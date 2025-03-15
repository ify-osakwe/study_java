package designPatterns.creational.builder;

import java.util.LinkedList;

public class ProductX {
    private final LinkedList<String> parts;

    public ProductX() {
        parts = new LinkedList<>();
    }

    public void add(String part) {
        parts.addLast(part);
    }

    public void show() {
        System.out.println("\n Product completed as below");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

class DirectorX {
    BuilderInterface myBuilder;

    public void construct(BuilderInterface builder) {
        myBuilder = builder;
        myBuilder.buildBody();
        myBuilder.insertWheels();
        myBuilder.addHeadlights();
    }
}


