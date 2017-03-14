package athens.org;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * App
 */
public class App extends BasicGame {
    private Paddle paddleLeft;

    private Input input;

    private App(String gamename) {
        super(gamename);
    }


    @Override
    public void init(GameContainer gc) throws SlickException {
        paddleLeft = new Paddle(0.5);

        input = gc.getInput();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        int speed = 100;
        float distance = speed * delta / 1000f;
        if (input.isKeyDown(Keyboard.KEY_UP)) {
            moveLeftPaddleUp(distance);
        }
        if (input.isKeyDown(Keyboard.KEY_DOWN)) {
            moveLeftPaddleDown(distance);
        }
    }


    private void moveRightPaddleDown() {
        // TODO TO BE IMPLEMENTED
    }

    private void moveRightPaddleUp() {
        // TODO TO BE IMPLEMENTED
    }

    private void moveLeftPaddleDown(float distance) {
        paddleLeft.setCenterY(paddleLeft.getCenterY() + distance);
    }

    private void moveLeftPaddleUp(float distance) {
        paddleLeft.setCenterY(paddleLeft.getCenterY() - distance);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        // TODO Write score on the screen
        g.draw(paddleLeft);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new App("Simple Slick Game"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
