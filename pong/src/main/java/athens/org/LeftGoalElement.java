package athens.org;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by peter on 16.03.17.
 */
public class LeftGoalElement extends Line implements Interactable {

    String playerName;

    public LeftGoalElement(Vector2f start, Vector2f end, String playerName) {
        super(start, end);
        this.playerName=playerName;
    }

    @Override
    public void interact(Ball ball) {
        if(ball.intersects(this)) {
            ball.setBallToCenter();
            ball.resetSpeed(Ball.DIRECTION.RIGHT);
            ScoreBoard.getInstance().incRightScore();
        }
    }

    @Override
    public boolean intersect(Shape shape) {
        return false;
    }

    public String getPlayerName() {
        return playerName;
    }
}
