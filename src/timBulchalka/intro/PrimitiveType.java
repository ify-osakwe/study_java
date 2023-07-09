package timBulchalka.intro;

public class PrimitiveType {
    public static void main(String[] args) {
        /*
         * In Java, primitive types are the most basic data types.
         * there are 8 types.
         * whole number - byte, short, int, long
         * real/floating point number - float, double
         * single character - char
         * boolean value - boolean
         */
        System.out.println("byte value range => " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short value range => " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("integer value range => " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long value range => " + Long.MIN_VALUE + " to " + Long.MAX_VALUE + "\n");

        System.out.println("Size of byte => " + Byte.SIZE);
        System.out.println("Size of short => " + Short.SIZE);
        System.out.println("Size of integer => " + Integer.SIZE);
        System.out.println("Size of Long => " + Long.SIZE + "\n");

        System.out.println("float range value => " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("double range value => " + Double.MAX_VALUE + " to " + Double.MAX_VALUE);

        System.out.println("Size of float => " + Float.SIZE);
        System.out.println("Size of double => " + Double.SIZE);

        // Java's default type for whole number is 'int'
        // Java's default type for floating number is 'double'

        /*
         * Java uses the concept of a wrapper class, for all of its 8 primitive data types
         * A wrapper class provides simple operations, as well as some basic information about the primitive data type,
         * which cannot be stored on the primitive itself.
         * the wrapper classes are => Byte. Short. Integer. Long. Float. Double. Character. Boolean
         *
         * For an Integer, if you put a value larger than the max value, you have an Overflow.
         * If you put a value smaller than the min value, you have an Underflow
         *
         * to improve readability, large numbers are separated with an underscore, not a comma
         * e.g. 2_147_483_647
         */
    }
}
