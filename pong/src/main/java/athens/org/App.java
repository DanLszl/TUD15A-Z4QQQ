package athens.org;

import athens.org.states.GameOverState;
import athens.org.states.PlayingState;
import athens.org.states.WelcomeState;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;


/**
 * App
 */
public class App extends StateBasedGame {
    private App(String gameName) {
        super(gameName);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appgc = new AppGameContainer(new App("PONG"));
        appgc.setDisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false);
        appgc.setShowFPS(false);
        appgc.setForceExit(false);
        appgc.start();
    }

    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(WelcomeState.getInstance());
        this.addState(PlayingState.getInstance());
        this.addState(GameOverState.getInstance());
    }
}
