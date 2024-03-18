package timBulchalka.codingExercise;

public class Exercise25 {

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4)); // Should print false
        System.out.println(canPack(1, 0, 5)); // Should print true
        System.out.println(canPack(0, 5, 4)); // Should print true
        System.out.println(canPack(2, 2, 11)); // Should print true
        System.out.println(canPack(-3, 2, 12)); // Should print false
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        int BIG_WEIGHT = 5;

        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        boolean result = false;
        int totalBigWeight = bigCount * BIG_WEIGHT;
        if (totalBigWeight >= goal) {
            int remaining = goal % BIG_WEIGHT;
            if (smallCount >= remaining) {
                result = true;
            }
        } else {
            if (smallCount >= goal - totalBigWeight) {
                result = true;
            }
        }
        return result;
    }

}
