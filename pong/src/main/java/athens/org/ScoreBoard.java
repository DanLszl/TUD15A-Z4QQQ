package athens.org;

import java.util.ArrayList;

/**
 * Created by peter on 14.03.17.
 */
public class ScoreBoard implements Subject{
    private static final int GOALS_TO_WIN = 5;
    private static ScoreBoard scoreBoard = new ScoreBoard();

    private ArrayList<Observer> observers= new ArrayList<>();

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
        this.scoreChanged();
    }

    public void incRightScore() {
        player2Score++;
        this.scoreChanged();
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

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void scoreChanged() {
        for(Observer observer:observers){
            observer.updateScore(this);
        }
    }

    @Override
    public String getScores() {
        return this.toString();
    }
}
