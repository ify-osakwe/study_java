package dsa.grokbook.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Words Concatenation.
 * Given a string and a list of words, find all the starting indices of substrings
 * in the given string that are a concatenation of all the given words exactly
 * once without any overlapping of words. It is given that all words are of the same length.
 */
public class SlideWindow11 {
    public static void main(String[] args) {
        String s1 = "catfoxcat";
        List<String> w1 = List.of(new String[]{"cat", "fox"});
        // Output: [0, 3] : The two substring containing both the words are "catfox" & "foxcat".

        String s2 = "catcatfoxfox";
        List<String> w2 = List.of(new String[]{"cat", "fox"});
        // Output: [3] : The only substring containing both the words is "catfox".

        System.out.println("Word Concatenation: " + findWordConcatenation(s1, w1.toArray(new String[0])));
        System.out.println("Word Concatenation: " + findWordConcatenation(s2, w2.toArray(new String[0])));
    }

    private static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeenMap = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFreqMap.containsKey(word)) break;

                wordsSeenMap.put(word, wordsSeenMap.getOrDefault(word, 0) + 1);
                if (wordsSeenMap.get(word) > wordFreqMap.getOrDefault(word, 0)) break;
                if (j + 1 == wordsCount) resultIndices.add(i);
            }
        }
        return resultIndices;
    }
}
