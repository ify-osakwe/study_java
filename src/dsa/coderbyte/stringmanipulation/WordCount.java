package dsa.coderbyte.stringmanipulation;

/****************************************************************
 *             CODERBYTE WORD COUNT CHALLENGE                   *
 *                                                              *
 * Problem Statement                                            *
 * Have the function WordCount(str) take the str string         *
 * parameter being passed and return the number of words the    *
 * string contains (e.g. "Never eat shredded wheat or cake"     *
 * would return 6). Words will be separated by single spaces.   *
 *                                                              *
 * Examples                                                     *
 * Input 1: "Hello World"                                       *
 * Output 1: 2                                                  *
 *                                                              *
 * Input 2: "one 22 three"                                      *
 * Output 2: 3                                                  *
 ***************************************************************/
public class WordCount {
    public static void main(String[] args) {
        System.out.println(wordCount("Hello world")); // 2
        System.out.println(wordCount("one 22 three")); // 3
        System.out.println(wordCount("Never eat shredded wheat or cake")); // 6
    }

    public static int wordCount(String text) {
        String[] stringArray = text.split(" ");

        return stringArray.length;
    }
}
