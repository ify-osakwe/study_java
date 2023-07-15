package timBulchalka.intro;

public class PrimitiveType2 {
    public static void main(String[] args) {
        /*
         * a whole number by default is an Integer. to specify a Long number
         * append literal with letter 'L'. since lowercase 'l' is quite confusing
         *
         * Also, to specify a float number, append with letter f - lower or upper case.
         * Since a double is the default for floating numbers, you don't need
         * to append letter D to it.
         */
        long aLongVariable = 43L;
        System.out.println(aLongVariable);

        Long bLongVariable = 2_234_342_345L;
        System.out.println(bLongVariable);

        float aFloat = 0.3221f;
        System.out.println(aFloat);


    }
}
