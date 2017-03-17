package athens.org;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by peter on 16.03.17.
 */
public class RightGoalElement extends Line implements Interactable {

    String playerName;

    public RightGoalElement(Vector2f start, Vector2f end, String playerName) {
        super(start, end);
        this.playerName=playerName;
    }

    @Override
    public void interact(Ball ball) {

        if(ball.intersects(this)) {
            ball.setBallToCenter();
            ball.resetSpeed(Ball.DIRECTION.LEFT);
            ScoreBoard.getInstance().incLeftScore();
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
