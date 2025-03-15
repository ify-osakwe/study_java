package timBuchalka.codingExercise;

public class Exercise15 {
    public static void main(String[] args) {

    }

    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        }
        return number % 2 != 0;
    }

    public static int sumOdd(int start, int end) {
        if (end < start) return -1;
        if (end < 0 || start < 0) return -1;

        int sum = 0;
        for (int i = start; i <= end; i++) {
            boolean isOdd = isOdd(i);
            if (isOdd) {
                sum += i;
            }
        }
        return sum;
    }
}
