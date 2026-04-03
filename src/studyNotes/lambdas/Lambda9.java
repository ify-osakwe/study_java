package studyNotes.lambdas;

interface OpFunc<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for (T val : vals) if (val == v) count++;
        return count;
    }
}

public class Lambda9 {
    static <T> int myOp(OpFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};

        int count;
        count = myOp(MyArrayOps::countMatching, vals, 4);
        System.out.println("vals contains " + count + " 4s");

        count = myOp(MyArrayOps::countMatching, strs, "Two");
        System.out.println("strs contains " + count + " Twos");
    }
}
