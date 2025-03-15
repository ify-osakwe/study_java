package timBuchalka.functions;

public class Method2 {
    public static void main(String[] args) {
        displayHighScorePosition("Tim", calculateHighScorePosition(1500));

        displayHighScorePosition("Kim", calculateHighScorePosition(1000));

        displayHighScorePosition("Bibi", calculateHighScorePosition(900));

        displayHighScorePosition("Cece", calculateHighScorePosition(500));

        displayHighScorePosition("Didi", calculateHighScorePosition(100));

        displayHighScorePosition("Efe", calculateHighScorePosition(25));

    }

    static void displayHighScorePosition(String playerName, int highScorePosition) {
        System.out.println(playerName + " managed to get into position "
                + highScorePosition + " on the high score list");
    }

    static int calculateHighScorePosition(int playerScore) {
        // return a number between 1 and 4 based on the score values shown below
        // 1 -> score greater than or equal to 1000
        // 2 -> score greater than or equal to 500 but less than 1000
        // 3 -> score greater than or equal to 100 but less than 500
        // 4 -> all other scores
        int position = 4;
        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }
        return position;
    }
}
