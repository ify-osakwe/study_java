package timBuchalka.functions;

public class Method7 {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(5, 0));
        System.out.println(convertToCentimeters(5,9));

        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(65, 145));
        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-65, 45));
    }

    public static double convertToCentimeters(int inches) {
        return 2.54 * inches;
    }

    public static double convertToCentimeters(int feet, int inches) {
        // https://www.metric-conversions.org/length/feet-to-centimeters.htm
        int feet2inch = feet * 12;
        int totalHeightInches = feet2inch + inches;
        return convertToCentimeters(totalHeightInches);
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid data for seconds(" + seconds + ") must be a +ve integer value";
        }
        return getDurationString(seconds / 60, seconds % 60);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Invalid data for seconds(" + minutes + ") must be a +ve integer value";
        }
        if (seconds <= 0 || seconds >= 59) {
            return "Invalid data for seconds(" + minutes + ") must be between 0 and 59";
        }
        int hours = minutes / 60;
        int remMinutes = minutes % 60;
        return hours + "h " + remMinutes + "m " + seconds + "s";
    }

}
