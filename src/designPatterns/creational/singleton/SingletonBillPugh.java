package designPatterns.creational.singleton;

public class SingletonBillPugh {

    private int data = 0;

    private SingletonBillPugh() {
    }

    public static SingletonBillPugh getInstance() {
       return SingletonHelper.uniqueInstance;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private static class SingletonHelper {
        private static final  SingletonBillPugh uniqueInstance = new SingletonBillPugh();

    }
}
