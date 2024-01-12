package designPatterns.creational.singleton;

public class SingletonDoubleCheckLock {
    private volatile static SingletonDoubleCheckLock uniqueInstance = null;

    private int data = 0;

    private SingletonDoubleCheckLock() {
    }

    public static SingletonDoubleCheckLock getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonDoubleCheckLock.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDoubleCheckLock();
                }
            }
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
