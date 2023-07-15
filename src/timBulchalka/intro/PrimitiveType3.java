package timBulchalka.intro;

public class PrimitiveType3 {
    public static void main(String[] args) {
        /*
         * A char type holds only one character and enclosed in a single quote.
         * A String can hold more than one character, and it is enclosed in double quotes.
         *
         * Java supports unicode for characters which can be used to represent a char value
         */
        char aLet = 'D';
        System.out.println(aLet);

        char aUnicode = '\u0052'; // Letter R
        System.out.println(aUnicode);

        char bUnicode = 82; // Letter R
        System.out.println(bUnicode);

        /*
         * A boolean value allows for two opposite choices.
         * In Java, a boolean can be set to two values - true or false
         */
    }
}
