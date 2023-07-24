package timBulchalka.functions;

public class Method5 {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19)); // true
        System.out.println(hasTeen(23, 15, 42)); // true
        System.out.println(hasTeen(22, 23, 34) + "\n"); // false

        System.out.println(isTeen(9)); // false
        System.out.println(isTeen(13)); // true
        System.out.println();
    }

    public static boolean areEqualByThreeDecimalPlaces(Double p1, Double p2) {
        int comp = p1.compareTo(p2);
//        if (p1 and p2 are same up to 3d p){
//            return true;
//        }
        return false;
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
