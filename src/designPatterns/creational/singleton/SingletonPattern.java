package designPatterns.creational.singleton;


/**
 * <p>
 *     Singleton examples -> logging, caching, thread pool,
 *     java.lang.Runtime, java.awt.Desktop, drivers objects.
 * </p>
 * <p>
 *     Ambient dependency = used by many classes and/or multiple layers.
 *     For ambient dependencies, a Singleton is preferable than a DI.
 * </p>
 */
public class SingletonPattern {
    public static void main(String[] args) {
        SingletonLazyEvaluation singleton = SingletonLazyEvaluation.getInstance();
        singleton.setData(55);

        SingletonSynchronized singleton1 = SingletonSynchronized.getInstance();
    }
}
