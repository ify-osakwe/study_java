package timBuchalka.intro;

public class IfStatement {
    public static void main(String[] args) {
        int res = returnAnInt(7);
        int result = returnAnInt(6);
        if (result % 2 == 0)
            System.out.println("Number is even");
        else
            System.out.println("number is odd");

        System.out.println(" ");
    }

    static int returnAnInt(int number) {
        return 3 * number;
    }
}
