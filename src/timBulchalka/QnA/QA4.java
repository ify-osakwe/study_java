package timBulchalka.QnA;

public class QA4 {
    public static void main(String[] args) {
        int a = 5;
        int b = a++; // b will be 5 and then a is incremented to 6
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("----------");

        int c = ++a; // a is already 6 and now incremented to 7
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

    }
}
