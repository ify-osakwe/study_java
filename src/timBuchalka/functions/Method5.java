package timBuchalka.functions;

public class Method5 {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.1756));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));

        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, -1, 0));
        System.out.println(hasEqualSum(10, 20, 30));
        System.out.println(hasEqualSum(0, 0, 0));

        System.out.println(hasTeen(9, 99, 19)); // true
        System.out.println(hasTeen(23, 15, 42)); // true
        System.out.println(hasTeen(22, 23, 34) + "\n"); // false

        System.out.println(isTeen(9)); // false
        System.out.println(isTeen(13)); // true
        System.out.println();
    }

    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        int scaledNum1 = (int) (num1 * 1000);
        int scaledNum2 = (int) (num2 * 1000);
        return scaledNum1 == scaledNum2;
    }

    public static boolean hasEqualSum(int p1, int p2, int p3) {
        int aSum = p1 + p2;
        return aSum == p3;
    }

    public static boolean hasTeen(int p1, int p2, int p3) {
        boolean aRange = p1 >= 13 && p1 <= 19;
        boolean bRange = p2 >= 13 && p2 <= 19;
        boolean cRange = p3 >= 13 && p3 <= 19;
        return aRange || bRange || cRange;
    }

    public static boolean isTeen(int p1) {
        return p1 >= 13 && p1 <= 19;
    }
}
