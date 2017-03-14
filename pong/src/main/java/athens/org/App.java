package athens.org;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App extends BasicGame
{

    Ball ball;

    public App(String gamename)
    {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        ball = new Ball(320, 240, Ball.DIRECTION.RIGHT);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        float seconds = delta / 1000f;
        Vector2f distance = new Vector2f(ball.getSpeed().x * seconds, ball.getSpeed().y * seconds);
        ball.translate(distance);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        g.draw(ball);
    }

    public static void main(String[] args)
    {
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new App("Simple Slick Game"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
