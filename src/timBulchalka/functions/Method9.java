package timBulchalka.functions;

public class Method9 {
    public static void main(String[] args) {
        printEqual(1, 1, 1);
        printEqual(1, 1, 2);
        printEqual(-1, -1, -1);
        printEqual(1, 2, 3);
    }

    public static void printEqual(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            System.out.println("Invalid Value");
            return;
        }
        if (a == b && b == c) {
            System.out.println("All numbers are equal");
            return;
        } else {
            System.out.println("All numbers are different");
        }
        System.out.println("Neither are equal or different");
    }
}
