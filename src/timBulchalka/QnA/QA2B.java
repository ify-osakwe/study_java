package timBulchalka.QnA;

import java.util.Scanner;

public class QA2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = 1;
        double min = 0;
        double max = 0;
        boolean charEntered = false;

        do {
            System.out.println("Enter a number");
            String num = scanner.nextLine();
            try {
                double value = Double.parseDouble(num);
                if (x == 0 || value < min) {
                    min = value;
                }
                if (x == 0 || value > max) {
                    max = value;
                }
                x++;
            } catch (NumberFormatException nfc) {
                charEntered = true;
            }
        } while (!charEntered);
        System.out.println("Loop count = " + x);

        if (x > 0) {
            System.out.println("min = " + min + " and max = " + max);
        } else {
            System.out.println("Invalid input");
        }
    }
}
