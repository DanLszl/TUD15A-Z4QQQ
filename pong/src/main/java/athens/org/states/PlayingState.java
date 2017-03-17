package athens.org.states;

import athens.org.*;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;
import java.util.Iterator;

import static athens.org.Constants.SCREEN_HEIGHT;
import static athens.org.Constants.SCREEN_WIDTH;
import static athens.org.Constants.SPEED;

/**
 * Created by peter on 14.03.17.
 */
public class PlayingState extends BasicGameState {

    private static PlayingState instance = new PlayingState();

    public static final int ID = 1;

    private Paddle paddleLeft;
    private Paddle paddleRight;

    private GameBorder border;

    private Font myFont2;
    private TrueTypeFont font2;

    private ScoreBoard scoreBoard;

    private Ball ball;

    private PlayingState() {
        super();
    }

    public static PlayingState getInstance() {
        return instance;
    }


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        paddleLeft = new Paddle(50f);
        paddleRight = new Paddle(590f);
        ball = new Ball(480, 240, Ball.DIRECTION.LEFT);
        border = new GameBorder(SCREEN_WIDTH, SCREEN_HEIGHT);

        myFont2 = new Font("Verdana", Font.BOLD, 30);
        font2 = new TrueTypeFont(myFont2, false);
        scoreBoard = ScoreBoard.getInstance();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.fill(paddleLeft);
        graphics.fill(paddleRight);

        graphics.fill(ball);
        //render scoreboard centered
        String scores = scoreBoard.toString();
        int scoreBoardWidth = font2.getWidth(scores);
        graphics.setFont(font2);
        graphics.drawString(scores, (SCREEN_WIDTH - scoreBoardWidth) / 2, 20);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();

        float seconds = delta / 1000f;
        float distance = SPEED * seconds;


        //check if keys are pressed
        if (input.isKeyDown(Keyboard.KEY_DOWN) && !border.getLowBorder().intersect(paddleRight)) {
            movePaddleDown(distance, paddleRight);
        }
        if (input.isKeyDown(Keyboard.KEY_UP) && !border.getUpperBorder().intersect(paddleRight)) {
            movePaddleUp(distance, paddleRight);
        }
        if (input.isKeyDown(Keyboard.KEY_S) && !border.getLowBorder().intersect(paddleLeft)) {
            movePaddleDown(distance, paddleLeft);
        }
        if (input.isKeyDown(Keyboard.KEY_W) && !border.getUpperBorder().intersect(paddleLeft)) {
            movePaddleUp(distance, paddleLeft);
        }

        if (paddleLeft.intersects(ball)) {
            ball.bounce(new Vector2f(1, 0), paddleLeft);
        }

        if (paddleRight.intersects(ball)) {
            ball.bounce(new Vector2f(-1, 0), paddleRight);
        }


        for (Iterator<Interactable> iter = border.getIterator(); iter.hasNext(); ) {
            iter.next().interact(ball);
        }

        ball.translate(seconds);

        //check if a player already one
        if (scoreBoard.isWinner()) {
            stateBasedGame.enterState(GameOverState.ID);
        }
    }

    private void movePaddleDown(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() + distance);
    }

    private void movePaddleUp(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() - distance);
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);

        scoreBoard.resetScores();
        ball.resetSpeed(Ball.DIRECTION.LEFT);
    }

}
