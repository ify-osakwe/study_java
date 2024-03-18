package timBulchalka.codingExercise;

public class Exercise14 {
    public static void main(String[] args) {

    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            boolean divisibleBy4 = year % 4 == 0;
            boolean notDivisibleBy100 = year % 100 != 0;
            boolean divisibleBy400 = year % 400 == 0;
            return (divisibleBy4 && notDivisibleBy100) || divisibleBy400;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }
        if (year < 1 || year > 9999) {
            return -1;
        }
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                boolean aLeapYear = isLeapYear(year);
                if (aLeapYear) yield 29;
                else yield 28;
            }
            default -> -1;
        };
    }
}
