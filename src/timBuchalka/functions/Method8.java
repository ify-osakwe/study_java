package timBuchalka.functions;

public class Method8 {
    public static void main(String[] args) {
        System.out.println(area(5.0));
        System.out.println(area(-1));
        System.out.println(area(5.0, 4.0));
        System.out.println(area(-1.0, 4.0) + "\n");

        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
        printYearsAndDays(-525600);
    }

    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        }
        return radius * radius * Math.PI;
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0) {
            return -1;
        }
        return x * y;
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        long hour = minutes / 60;
        long day = hour / 24;
        long year = day / 365;
        System.out.println(minutes + " min = " + year + " y and " + (day % 365) + " d");
    }
}
