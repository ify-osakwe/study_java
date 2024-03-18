package timBulchalka.codingExercise;

public class Exercise16 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12345));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(-12321));
        System.out.println(isPalindrome(-12345));
    }

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);
        String numberString = Integer.toString(number);

        int left = 0;
        int right = numberString.length() - 1;
        while (left < right) {
            if (numberString.charAt(left) != numberString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
