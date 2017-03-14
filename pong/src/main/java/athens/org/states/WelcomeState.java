package athens.org.states;

import athens.org.Constants;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

/**
 * Created by peter on 14.03.17.
 */
public class WelcomeState extends BasicGameState {

    public static final int ID = 0;
    private String welcomeText;
    private float textWidth;
    private Font myFont;
    private TrueTypeFont font;


    @Override
    public int getID() {
        return WelcomeState.ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //set up font
        myFont= new Font("Verdana", Font.BOLD, 60);
        font=new TrueTypeFont(myFont, false);

        welcomeText="PONG";
        textWidth=font.getWidth(welcomeText);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.clear();
        font.drawString((Constants.SCREEN_WIDTH-textWidth)/2,(Constants.SCREEN_HEIGHT-font.getHeight())/2,welcomeText);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
