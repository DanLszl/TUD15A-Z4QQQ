package athens.org;

import athens.org.states.PlayingState;
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
    public App(String gamename)
    {
        super(gamename);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new WelcomeState());
        this.addState(new PlayingState());
    }

    public static void main(String[] args) throws SlickException
    {
        AppGameContainer appgc=new AppGameContainer(new App("PONG"));
        appgc.setDisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false);
        appgc.setShowFPS(false);
        appgc.setForceExit(false);
        appgc.start();
    }
}
