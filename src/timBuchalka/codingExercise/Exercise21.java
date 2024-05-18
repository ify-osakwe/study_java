package timBuchalka.codingExercise;

public class Exercise21 {
    public static void main(String[] args) {
        printFactors(6); // Should print: 1 2 3 6
        printFactors(10); // Should print: 1 2 5 10
        printFactors(-1); // Should print: Invalid Value
        printFactors(0); // Should print: Invalid Value
        printFactors(25); // Should print: 1 5 25
    }

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
