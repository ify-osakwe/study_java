package playground;

public class WordleGame {
    public static void main(String[] args) {
        String guess = "elate";
        String word = "bible";
        String result = colorizedWordle(guess, word);
        System.out.println(result);
    }

    public static String colorizedWordle(String guess, String word) {
        StringBuilder result = new StringBuilder();
        boolean[] usedIndices = new boolean[word.length()];

        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            boolean found = false;

            for (int j = 0; j < word.length(); j++) {
                char wordChar = word.charAt(j);

                if (usedIndices[j]) {
                    continue;
                }

                if (guessChar == wordChar) {
                    if (i == j) {
                        result.append('G');
                    } else {
                        result.append('Y');
                    }
                    usedIndices[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.append('B');
            }
        }

        return result.toString();
    }
}

