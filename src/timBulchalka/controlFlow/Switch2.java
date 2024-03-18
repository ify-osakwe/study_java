package timBulchalka.controlFlow;

public class Switch2 {
    public static void main(String[] args) {
        int switchValue = getACode();

        // The Enhanced switch statement
        // fall-through doesn't occur here unlike the traditional syntax.
        switch (switchValue) {
            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("Value is 2");
            case 3, 4, 5 -> System.out.println("Was a 3, 4, or 5");
            default -> System.out.println("Value is greater than 5" + "\n");
        }

        String month = "OCTOBER";
        System.out.println(month + " is in the " + getQuarter(month) + " quarter");
        String month2 = "JULY";
        System.out.println(month2 + " is in the " + getQuarter2(month2) + " quarter");
    }

    public static int getACode() {
        return 3 * 2;
    }

    // Returning a value in the traditional switch syntax
    public static String getQuarter(String month) {
        switch (month) {
            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
                return "1st";
            case "APRIL":
            case "MAY":
            case "JUNE":
                return "2nd";
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                return "3rd";
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                return "4th";
        }
        return "bad";
    }

    // Returning a value in the enhanced switch syntax.
    // 'yield' is used in a code block in an enhanced switch statement
    // instead of 'return'
    public static String getQuarter2(String month) {
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                double code = 4 * Math.PI;
                yield "bad" + code;
            }
        };
    }
}
