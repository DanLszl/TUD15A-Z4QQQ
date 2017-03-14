package athens.org;

import athens.org.states.WelcomeState;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App extends StateBasedGame
{
    public App(String gamename)
    {
        super(gamename);
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
        }
        catch (SlickException ex)
        {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
