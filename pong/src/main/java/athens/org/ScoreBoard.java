package athens.org;

/**
 * Created by peter on 14.03.17.
 */
public class ScoreBoard {
    private static final int GOALS_TO_WIN = 5;
    private static ScoreBoard scoreBoard = new ScoreBoard();

    private int player1Score;
    private int player2Score;

    private ScoreBoard() {
        player1Score = 0;
        player2Score = 0;
    }

    public static ScoreBoard getInstance() {
        return scoreBoard;
    }

    public void resetScores() {
        player1Score = 0;
        player2Score = 0;
    }

    public void incLeftScore() {
        player1Score++;
    }

    public void incRightScore() {
        player2Score++;
    }

    public boolean isWinner() {
        return player1Score >= GOALS_TO_WIN || player2Score >= GOALS_TO_WIN;
    }

    public String getWinner() {
        if (player1Score >= 5) {
            return "Player 1";
        }

        return "Player 2";

    }

    @Override
    public String toString() {
        return player1Score + " : " + player2Score;
    }

}
