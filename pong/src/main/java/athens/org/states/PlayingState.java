package athens.org.states;

import athens.org.Ball;
import athens.org.Constants;
import athens.org.GameBorder;
import athens.org.Paddle;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.Font;

/**
 * Created by peter on 14.03.17.
 */
public class PlayingState extends BasicGameState {

    public static final int ID=1;
    private static final int WINS_NEEDED=5;

    private Paddle paddleLeft;
    private Paddle paddleRight;

    private GameBorder border;
    private Input input;

    private Font myFont2;
    private TrueTypeFont font2;

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

        //TODO change hardcoded screen size
        border = new GameBorder(640f, 480f);

        input = gameContainer.getInput();

        myFont2= new Font("Verdana", Font.BOLD, 30);
        font2=new TrueTypeFont(myFont2, false);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.fill(paddleLeft);
        graphics.fill(paddleRight);
        border = new GameBorder(640f, 480f);

        input = gameContainer.getInput();

        //render scoreboard centered
        String scoreBoard=paddleLeft.getScore()+" : " +paddleRight.getScore();
        int scoreBoardWidth=font2.getWidth(scoreBoard);
        graphics.setFont(font2);
        graphics.drawString(scoreBoard, (Constants.SCREEN_WIDTH-scoreBoardWidth)/2,20);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        int speed = 100;
        Input input=gameContainer.getInput();

        float distance = speed * delta / 1000f;
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



        

        //check if a player already one, TODO: pass player that one to gameoverscreen
        if(paddleLeft.getScore()>=WINS_NEEDED){
            stateBasedGame.enterState(GameOverState.ID);
        }

        if(paddleRight.getScore()>=WINS_NEEDED){
            stateBasedGame.enterState(GameOverState.ID);
        }

    }

    private void movePaddleDown(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() + distance);
    }

    private void movePaddleUp(float distance, Paddle paddle) {
        paddle.setCenterY(paddle.getCenterY() - distance);
    }
}
