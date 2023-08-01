package timBulchalka.controlFlow;

public class Switch1 {
    public static void main(String[] args) {
        int switchValue = getACode();
        /*
         * The traditional switch statement
         *
         * Valid switch value types:
         * byte, short, int, char
         * Byte, Short, Integer, Character
         * String, enum
         */
        switch (switchValue) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Was a 3, 4, or 5");
            default:
                System.out.println("Value is greater than 5");
        }
    }

    public static int getACode() {
        return 3 * 2;
    }
}
