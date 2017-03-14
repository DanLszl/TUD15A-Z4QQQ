package athens.org.states;

import athens.org.Ball;
import athens.org.Paddle;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by peter on 14.03.17.
 */
public class PlayingState extends BasicGameState {

    public static final int ID=1;

    private Paddle paddleLeft;
    private Paddle paddleRight;

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
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.fill(paddleLeft);
        graphics.fill(paddleRight);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        int speed = 100;
        Input input=gameContainer.getInput();

        float distance = speed * delta / 1000f;
        if (input.isKeyDown(Keyboard.KEY_UP)) {
            movePaddleUp(distance, paddleRight);
        }
        if (input.isKeyDown(Keyboard.KEY_DOWN)) {
            movePaddleDown(distance, paddleRight);
        }
        if(input.isKeyDown(Keyboard.KEY_S)){
            movePaddleDown(distance, paddleLeft);
        }
        if(input.isKeyDown(Keyboard.KEY_W)){
            movePaddleUp(distance, paddleLeft);
        }
    }

    private void movePaddleDown(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() + distance);
    }

    private void movePaddleUp(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() - distance);
    }
}
