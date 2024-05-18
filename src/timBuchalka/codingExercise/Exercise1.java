package timBuchalka.codingExercise;

public class Exercise1 {
    public static void main(String[] args) {
        checkNumber(54);
        checkNumber(-2);
        checkNumber(18);
        checkNumber(3);
        checkNumber(0);
        checkNumber(-32);
        checkNumber(7);

    }

    public static void checkNumber(int number) {
//        if (number == 0) {
//            System.out.println("zero");
//        }
//        if (number < 0) {
//            System.out.println("negative");
//        }
//        if (number > 0) {
//            System.out.println("positive");
//        }
        if (number > 0) {
            System.out.println("positive");
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");
        }
    }
}
