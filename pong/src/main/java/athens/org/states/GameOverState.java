package athens.org.states;

import athens.org.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.Font;

/**
 * Created by peter on 14.03.17.
 */
public class GameOverState extends BasicGameState {

    public static final int ID=2;

    private String gameOverText;
    private String informationText;
    private String winnerText;
    private float textWidth;
    private float textWidth2;
    private float textWidth3;
    private Font myFont;
    private TrueTypeFont font;

    private Font myFont2;
    private TrueTypeFont font2;

    private Font myFont3;
    private TrueTypeFont font3;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        int winner=1; //TODO: change to real winner

        myFont= new Font("Verdana", Font.BOLD, 60);
        font=new TrueTypeFont(myFont, false);

        myFont2= new Font("Verdana", Font.BOLD, 30);
        font2=new TrueTypeFont(myFont2, false);

        myFont3= new Font("Verdana", Font.BOLD, 20);
        font3=new TrueTypeFont(myFont3, false);

        gameOverText="GAME OVER";
        winnerText="PLAYER "+winner+" WON";
        informationText="Press <ENTER> to restart or <ESC> to exit";
        textWidth=font.getWidth(gameOverText);
        textWidth2=font2.getWidth(winnerText);
        textWidth3=font3.getWidth(informationText);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.clear();
        graphics.setFont(font);
        graphics.drawString(gameOverText,(Constants.SCREEN_WIDTH-textWidth)/2,140);
        graphics.setFont(font2);
        graphics.drawString(winnerText,(Constants.SCREEN_WIDTH-textWidth2)/2,240);
        graphics.setFont(font3);
        graphics.drawString(informationText,(Constants.SCREEN_WIDTH-textWidth3)/2,(Constants.SCREEN_HEIGHT-100));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if(gameContainer.getInput().isKeyDown(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }

        if(gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)){
            stateBasedGame.enterState(WelcomeState.ID);
        }
    }
}
