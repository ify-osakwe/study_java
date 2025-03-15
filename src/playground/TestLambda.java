package playground;

import java.util.Comparator;

public class TestLambda {
    public static void main(String[] args) {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Howdy");
            }
        };
        myRunnable.run();
        // rewriting above with lambda expression
        Runnable myRunnable2 = () -> System.out.println("Howdy lambda\n");
        myRunnable2.run();

        /*
         * Lambda expressions work with functional interfaces.
         * A functional interface is an interface that requires exactly one method to be implemented
         * in order to satisfy the requirements of the interface
         *
         * A lambda consists of 3 parts :-
         * 1. a parenthesized set of parameters,
         * 2. an arrow,
         * 3. a body, which can either be a single expression or a block of Java code
         */
        MyFunctionalInterface functionalInterface = new MyFunctionalInterface() {
            @Override
            public void printOut(Integer number) {
                System.out.println("number is " + number);
            }
        };
        functionalInterface.printOut(23);

        MyFunctionalInterface functionalInterface2 = number -> System.out.println("number is -> " + number);

        Comparator<String> c = (lhs, rhs) -> lhs.compareTo(rhs);
        // Comparator<String> c = String::compareTo;
        int result = c.compare("Hello", "World");

    }

    interface MyFunctionalInterface {
        void printOut(Integer number);
    }
}
