package timBuchalka.utility;

import java.util.regex.Pattern;

public class Regex04 {
    public static void main(String[] args) {
        String[] texts = {"Jenny", "Jada", "Kaka", "abc"};

        // Any character except a, b, or c (negation)
        String pattern = "[^abc]";

        // a, b, or c (simple class)
        String pattern1 = "[abc]";

        // a through z or A through Z, inclusive (range)
        String pattern2 = "[a-zA-Z]";

        for (String s : texts) {
            if (Pattern.matches(pattern1, s)) {
                System.out.println(s + " MATCHES " + pattern1);
            } else {
                System.out.println(s + " DOES NOT MATCH " + pattern1);
            }
        }
        
    }
}
