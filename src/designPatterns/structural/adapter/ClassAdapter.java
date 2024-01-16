package designPatterns.structural.adapter;

interface IntegerValueInterface {
    int getInteger();
}

class IntegerValue implements IntegerValueInterface {

    @Override
    public int getInteger() {
        return 5;
    }
}

class AdapterX extends IntegerValue {
    @Override
    public int getInteger() {
        return 2 + super.getInteger();
    }
}


public class ClassAdapter {
    public static void main(String[] args) {
        AdapterX adapter = new AdapterX();
        System.out.println("Class Adapter is returning " + adapter.getInteger());
    }
}
