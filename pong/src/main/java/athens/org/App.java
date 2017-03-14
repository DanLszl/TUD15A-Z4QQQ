package athens.org;

import org.lwjgl.input.Keyboard;
import athens.org.states.WelcomeState;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * App
 */
public class App extends StateBasedGame
{
    private Paddle paddleLeft;
    private Paddle paddleRight;

    Ball ball;

    public App(String gamename)
    {
        super(gamename);
    }
    
    private Input input;

    @Override
    public void init(GameContainer gc) throws SlickException {
        paddleLeft = new Paddle(50f);
        paddleRight = new Paddle(590f);

        input = gc.getInput();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        int speed = 100;
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

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        // TODO Write score on the screen
        g.fill(paddleLeft);
        g.fill(paddleRight);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new WelcomeState());
    }

    public static void main(String[] args)
    {

        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new App("Simple Slick Game"));
            appgc.setDisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
