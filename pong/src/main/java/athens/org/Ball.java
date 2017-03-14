package athens.org;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

import java.util.Random;

import static athens.org.Ball.DIRECTION.LEFT;

/**
 * Created by Dani on 3/14/2017.
 */
public class Ball extends Circle {

    public Vector2f getSpeed() {
        return speed;
    }

    public void translate(Vector2f distance) {
        setCenterX(getCenterX() + distance.getX());
        setCenterY(getCenterY() + distance.getY());
    }

    public enum DIRECTION {
        LEFT, RIGHT
    }

    private static final int speedLength = 100;
    private static final int radius = 20;
    private static Random randomGenerator = new Random();

    private Vector2f speed;

    public Ball(float centerPointX, float centerPointY, DIRECTION direction) {
        super(centerPointX, centerPointY, radius);

        int angle;
        if (direction == LEFT) {
            angle = randomGenerator.nextInt(180) - 90 + 180;
        } else {
            angle = randomGenerator.nextInt(180) - 90;
        }
        speed = new Vector2f((float) Math.cos(Math.toRadians(angle)) * speedLength, (float) Math.sin(Math.toRadians(angle)) * speedLength);
    }
}
