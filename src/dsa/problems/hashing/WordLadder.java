package dsa.problems.hashing;

import java.util.*;

/**
 * Word Ladder Problem
 * <a href="https://gemini.google.com/share/4bf5e48f98b6">Gemini Link</a>
 */
public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. Convert List to Set for O(1) lookups.
        Set<String> dict = new HashSet<>(wordList);

        // Edge case: If endWord isn't in the dictionary, we can never reach it.
        if (!dict.contains(endWord)) {
            return 0;
        }

        // 2. Initialize BFS structures
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // We use the dictionary itself to track visited words to save space.
        // Alternatively, use a separate Set<String> visited.
        // Once we add a word to the queue, we remove it from dict so we don't visit it again.
        dict.remove(beginWord);

        // The problem says the sequence includes the beginWord, so start count at 1.
        int level = 1;

        // 3. BFS Loop
        while (!queue.isEmpty()) {
            int size = queue.size(); // Process this level entirely

            // Iterate over all words currently at this level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Check all possible transformations
                char[] wordChars = currentWord.toCharArray();

                // Try changing each character (position j)
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    // Try replacing with 'a' through 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // If we found the target, we are done.
                        // We return level + 1 because the current 'level' is the length *to* currentWord,
                        // and newWord (endWord) is the next step.
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the transformed word is valid (in dict), add to queue
                        if (dict.contains(newWord)) {
                            queue.offer(newWord);
                            // Mark as visited by removing from valid set
                            dict.remove(newWord);
                        }
                    }

                    // IMPORTANT: Restore the character for the next iteration of the inner loop
                    // e.g., if we changed "hit" -> "ait", we need to restore to "hit"
                    // before trying "bit".
                    wordChars[j] = originalChar;
                }
            }

            // We finished processing this layer of the "onion", increment distance.
            level++;
        }

        // If queue is empty and we never hit endWord
        return 0;
    }

    public static void main(String[] args) {

        // Example 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println("--- Test Case 1 ---");
        System.out.println("Start: " + beginWord1 + ", End: " + endWord1);
        System.out.println("Word List: " + wordList1);
        int result1 = ladderLength(beginWord1, endWord1, wordList1);
        System.out.println("Shortest Path Length: " + result1); // Expected: 5

        // Example 2 (Impossible case)
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log")); // 'cog' is missing

        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Start: " + beginWord2 + ", End: " + endWord2);
        System.out.println("Word List: " + wordList2);
        int result2 = ladderLength(beginWord2, endWord2, wordList2);
        System.out.println("Shortest Path Length: " + result2); // Expected: 0
    }
}
