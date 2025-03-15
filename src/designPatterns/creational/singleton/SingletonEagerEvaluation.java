package designPatterns.creational.singleton;

public class SingletonEagerEvaluation {
    private static final SingletonEagerEvaluation uniqueInstance = new SingletonEagerEvaluation();

    private SingletonEagerEvaluation() {
    }

    public static SingletonEagerEvaluation getInstance() {
        return uniqueInstance;
    }
}
