package timBulchalka.functions;

public class Method4 {
    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600)); // false
        System.out.println(isLeapYear(1600)); // true
        System.out.println(isLeapYear(2017)); // false
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(1800)); // false
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
}
