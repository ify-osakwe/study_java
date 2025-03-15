package playground;

import java.util.HashMap;
import java.util.Map;

public class WordleGame2 {
    public static void main(String[] args) {
        String guess = "mamma";
        String word = "maxim";
        String result = colorizedWordle(guess, word);
        System.out.println(result); // Output: "GGYBB"
    }

    public static String colorizedWordle(String guess, String word) {
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> wordMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char guessChar = guess.charAt(i);

            if (wordChar == guessChar) {
                result.append("G");
            } else {
                wordMap.put(wordChar, wordMap.getOrDefault(wordChar, 0) + 1);
                guessMap.put(guessChar, guessMap.getOrDefault(guessChar, 0) + 1);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char guessChar = guess.charAt(i);

            if (wordChar != guessChar && wordMap.containsKey(guessChar)) {
                result.append("Y");
                wordMap.put(guessChar, wordMap.get(guessChar) - 1);
                if (wordMap.get(guessChar) == 0) {
                    wordMap.remove(guessChar);
                }
            } else if (wordChar != guessChar && !wordMap.containsKey(guessChar) && !guessMap.containsKey(wordChar)) {
                result.append("B");
            }
        }

        return result.toString();
    }
}

