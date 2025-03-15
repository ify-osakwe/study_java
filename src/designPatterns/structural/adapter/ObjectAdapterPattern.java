package designPatterns.structural.adapter;

interface Duck {
    void quack();

    void fly();
}

class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("MallardDuck quack");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck fly");
    }
}

interface Turkey {
    void gobble();

    void fly();
}

class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("WildTurkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("WidTurkey fly SHORT");
    }
}

class TurkeyAdapter implements Duck {
    Turkey turkey;

    TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}

public class ObjectAdapterPattern {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();

        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        System.out.println("The turkey says ...");
        wildTurkey.gobble();
        wildTurkey.fly();

        System.out.println("\nThe duck says ...");
        operationOnDuck(mallardDuck);

        System.out.println("\nThe TurkeyAdapter says ...");
        operationOnDuck(turkeyAdapter);
    }

    static void operationOnDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
