package athens.org.states;

import athens.org.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.*;

import java.awt.*;
import java.awt.Font;

/**
 * Created by peter on 14.03.17.
 */
public class WelcomeState extends BasicGameState {
    public static final int ID = 0;


    private static WelcomeState instance=new WelcomeState();

    private String welcomeText;
    private String informationText;
    private float textWidth;
    private float textWidth2;
    private Font myFont;
    private TrueTypeFont font;

    private Font myFont2;
    private TrueTypeFont font2;

    private WelcomeState(){
        super();
    }

    public static WelcomeState getInstance(){
        return instance;
    }

    @Override
    public int getID() {
        return WelcomeState.ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //set up font
        myFont= new Font("Verdana", Font.BOLD, 60);
        font=new TrueTypeFont(myFont, false);

        myFont2= new Font("Verdana", Font.BOLD, 20);
        font2=new TrueTypeFont(myFont2, false);

        welcomeText="PONG";
        informationText="Press <SPACE> to start";
        textWidth=font.getWidth(welcomeText);
        textWidth2=font2.getWidth(informationText);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.clear();
        graphics.setFont(font);
        graphics.drawString(welcomeText,(Constants.SCREEN_WIDTH-textWidth)/2,(Constants.SCREEN_HEIGHT-font.getHeight())/2);
        graphics.setFont(font2);
        graphics.drawString(informationText,(Constants.SCREEN_WIDTH-textWidth2)/2,(Constants.SCREEN_HEIGHT-60));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        //if space key is pressed, game is started
        if(gameContainer.getInput().isKeyDown(Input.KEY_SPACE)){
            stateBasedGame.enterState(PlayingState.ID);
        }
    }
}
