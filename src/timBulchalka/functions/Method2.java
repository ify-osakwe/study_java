package timBulchalka.functions;

public class Method2 {
    public static void main(String[] args) {
        // display result for the following scores: 1500, 1000, 500, 100, 25

        int aScore = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", aScore);

        int bScore = calculateHighScorePosition(1000);
        displayHighScorePosition("Kim", bScore);

        int bbScore = calculateHighScorePosition(900);
        displayHighScorePosition("Bibi", bbScore);

        int cScore = calculateHighScorePosition(500);
        displayHighScorePosition("Cece", cScore);

        int dScore = calculateHighScorePosition(100);
        displayHighScorePosition("Didi", dScore);

        int eScore = calculateHighScorePosition(25);
        displayHighScorePosition("Efe", eScore);

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
