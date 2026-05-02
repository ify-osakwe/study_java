package studyNotes.playground;

class Tester {
    int a, b;

    Tester(int i, int j) {
        a = i;
        b = j;
    }

    void meth(Tester o) {
        o.a *= 2;
        o.b /= 2;
    }
}

public class CallByReferenceOrValue {
    public static void main(String[] args) {
        Tester ob = new Tester(15, 20);
        Tester ob2 = new Tester(15, 20);

        System.out.println("ob.a and ob.b before call: " +
                ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("ob.a and ob.b after call: " +
                ob.a + " " + ob.b);
        System.out.println();

        System.out.println("ob2.a and ob2.b before call: " +
                ob2.a + " " + ob2.b);
        ob.meth(ob2);
        System.out.println("ob2.a and ob2.b after call: " +
                ob2.a + " " + ob2.b);
    }
}
