package timBuchalka.controlFlow;

public class ForLoop1 {
    public static void main(String[] args) {
        /*
         * Looping in Java
         * 1. for loop = quite complex but commonly used when iterating
         * over a set of value.
         * 2. while loop = executes until a specified condition becomes false.
         * 3. do while loop = executes at least once and continues until a
         * specified condition becomes false.
         */
        for (int counter = 0; counter <= 5; counter++) {
            System.out.println(counter);
        }

        for (double rate = 2.0; rate <= 5.0; rate++) {
            double interestAmount = calculateInterest(10000.0, rate);
            System.out.println("10,000 at " + rate + "% interest = " + interestAmount);
        }

        for (int i = 0; i < 10; i++) {
            if (i > 6) break;
            System.out.println("index " + i);
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
}
