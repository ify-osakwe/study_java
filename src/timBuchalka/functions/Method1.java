package timBuchalka.functions;

public class Method1 {
    public static void main(String[] args) {
        calculateScore(true, 800, 5, 100);
        calculateScore(false, 400, 2, 50);

        int highScore = calculateScoreAndReturn(true, 350, 7, 100);
        System.out.println("high score is " + highScore);

        int highScore2 = calculateScoreAndReturn(false, 360, 3, 20);
        System.out.println("High score is " + highScore2);
    }

    static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        } else {
            System.out.println("No final score");
        }
    }

    static int calculateScoreAndReturn(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            return finalScore + 1000;
        } else {
            return finalScore;
        }
    }
}
