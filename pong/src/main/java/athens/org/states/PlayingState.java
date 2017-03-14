package athens.org.states;

import athens.org.Ball;
import athens.org.GameBorder;
import athens.org.Paddle;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by peter on 14.03.17.
 */
public class PlayingState extends BasicGameState {

    public static final int ID=1;

    private Paddle paddleLeft;
    private Paddle paddleRight;

    private GameBorder border;
    private Input input;

    Ball ball;

    public PlayingState(){
        super();
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

        //TODO change hardcoded screen size
        border = new GameBorder(640f, 480f);

        input = gameContainer.getInput();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.fill(paddleLeft);
        graphics.fill(paddleRight);
        border = new GameBorder(640f, 480f);

        graphics.fill(ball);

        input = gameContainer.getInput();

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        //TODO move it to constants
        int speed = 100;
        Input input=gameContainer.getInput();

        float seconds = delta / 1000f;
        float distance = speed * seconds;
        if (input.isKeyDown(Keyboard.KEY_DOWN) && !border.intersectLower(paddleRight)) {
            movePaddleDown(distance, paddleRight);
        }
        if (input.isKeyDown(Keyboard.KEY_UP) && !border.intersectUpper(paddleRight)) {
            movePaddleUp(distance, paddleRight);
        }
        if (input.isKeyDown(Keyboard.KEY_S) && !border.intersectLower(paddleLeft)) {
            movePaddleDown(distance, paddleLeft);
        }
        if (input.isKeyDown(Keyboard.KEY_W) && !border.intersectUpper(paddleLeft)) {
            movePaddleUp(distance, paddleLeft);
        }

        if (!border.intersectLower(ball)) {
            ball.translate(seconds);
        } else {
            ball.bounce(new Vector2f(0, -1), border.getUpperBound());
        }

        if (!border.intersectUpper(ball)) {
            ball.translate(seconds);
        } else {
            ball.bounce(new Vector2f(0, 1), border.getLowerBound());
        }

        if (!paddleLeft.intersects(ball)) {
            ball.translate(seconds);
        } else {
            ball.bounce(new Vector2f(1,0), paddleLeft);
        }

        if (!paddleRight.intersects(ball)) {
            ball.translate(seconds);
        } else {
            ball.bounce(new Vector2f(-1,0), paddleRight);
        }
    }

    private void movePaddleDown(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() + distance);
    }

    private void movePaddleUp(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() - distance);
    }
}
