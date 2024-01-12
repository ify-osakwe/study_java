package designPatterns.creational.singleton;

public class SingletonLazyEvaluation {
    private static SingletonLazyEvaluation uniqueInstance = null;

    private int data = 0;

    private SingletonLazyEvaluation() {
    }

    public static SingletonLazyEvaluation getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonLazyEvaluation();
        }
        return uniqueInstance;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
