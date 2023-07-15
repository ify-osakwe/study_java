package timBulchalka.intro;

public class StringType {
    public static void main(String[] args) {
        /*
         * A String is a class that can hold a sequence of characters
         * A String is immutable, you cannot change it after it is created
         * another class - StringBuilder - it is mutable
         */
        String aString = "Hello brother";
        System.out.println(aString);
        System.out.println(aString + ", nice to see you again"); // concatenating strings
        System.out.println("I need \u002450");
    }
}
