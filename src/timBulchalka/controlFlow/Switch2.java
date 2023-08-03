package timBulchalka.controlFlow;

public class Switch2 {
    public static void main(String[] args) {
        int switchValue = getACode();
        /*
         * The Enhanced switch statement
         * fall-through doesn't occur here unlike the traditional syntax.
         */
        switch (switchValue) {
            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("Value is 2");
            case 3, 4, 5 -> System.out.println("Was a 3, 4, or 5");
            default -> System.out.println("Value is greater than 5");
        }
    }

    public static int getACode() {
        return 3 * 2;
    }

    public static String getQuarter(String month) {
        // Returning a value in the traditional switch syntax
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

    public static String getQuarter2(String month) {
        // Returning a value in the enhanced switch syntax.
        // 'yield' is used in a code block in an enhanced switch statement
        // instead of 'return'
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
