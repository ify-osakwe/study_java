package designPatterns.creational.singleton;

public class SingletonSynchronized {
    private static SingletonSynchronized uniqueInstance = null;

    private int data = 0;

    private SingletonSynchronized() {
    }

    /***
     * by adding 'synchronized', we force every thread to wait its turn before
     * it can enter the method
     */
    public static synchronized SingletonSynchronized getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SingletonSynchronized();
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
