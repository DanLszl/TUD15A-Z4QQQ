package athens.org.states;

import athens.org.Constants;
import athens.org.ScoreBoard;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.Font;

/**
 * Created by peter on 14.03.17.
 */
public class GameOverState extends BasicGameState {

    public static final int ID = 2;
    private static GameOverState instance = new GameOverState();
    private String gameOverText;
    private String informationText;
    private String winnerText;
    private float textWidth;
    private float textWidth2;
    private float textWidth3;

    private TrueTypeFont verdanaBigTrueType;

    private TrueTypeFont verdanaMediumTrueType;

    private TrueTypeFont verdanaSmallTrueType;


    private GameOverState() {
    }


    public static GameOverState getInstance() {
        return instance;
    }


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Font verdanaBig = new Font("Verdana", Font.BOLD, 60);
        verdanaBigTrueType = new TrueTypeFont(verdanaBig, false);

        Font verdanaMedium = new Font("Verdana", Font.BOLD, 30);
        verdanaMediumTrueType = new TrueTypeFont(verdanaMedium, false);

        Font verdanaSmall = new Font("Verdana", Font.BOLD, 20);
        verdanaSmallTrueType = new TrueTypeFont(verdanaSmall, false);

        gameOverText = "GAME OVER";
        informationText = "Press <ENTER> to restart or <ESC> to exit";
        textWidth = verdanaBigTrueType.getWidth(gameOverText);
        textWidth3 = verdanaSmallTrueType.getWidth(informationText);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.clear();
        graphics.setFont(verdanaBigTrueType);
        graphics.drawString(gameOverText, (Constants.SCREEN_WIDTH - textWidth) / 2, 140);
        graphics.setFont(verdanaMediumTrueType);
        graphics.drawString(winnerText, (Constants.SCREEN_WIDTH - textWidth2) / 2, 240);
        graphics.setFont(verdanaSmallTrueType);
        graphics.drawString(informationText, (Constants.SCREEN_WIDTH - textWidth3) / 2, (Constants.SCREEN_HEIGHT - 100));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        if (gameContainer.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            gameContainer.exit();
        }

        if (gameContainer.getInput().isKeyPressed(Input.KEY_ENTER)) {
            stateBasedGame.enterState(WelcomeState.ID);
        }
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);

        String winner = ScoreBoard.getInstance().getWinner();
        winnerText = winner + " WON";
        textWidth2 = verdanaMediumTrueType.getWidth(winnerText);

    }
}
