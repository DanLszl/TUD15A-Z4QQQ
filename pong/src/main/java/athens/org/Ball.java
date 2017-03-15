package athens.org;

import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.util.Random;

import static athens.org.Ball.DIRECTION.LEFT;

/**
 * Created by Dani on 3/14/2017.
 */
public class Ball extends Circle {

    private static final int speedLength = 100;
    private static final int radius = 20;
    private static Random randomGenerator = new Random();
    private int bounceCounter=0;
    private Shape lastHit;
    private Vector2f speed;

    public Ball(float centerPointX, float centerPointY, DIRECTION direction) {
        super(centerPointX, centerPointY, radius);

        resetSpeed(direction);
    }

    public void translate(float seconds) {
        Vector2f distance = new Vector2f(speed.x * seconds, speed.y * seconds);
        setCenterX(getCenterX() + distance.getX());
        setCenterY(getCenterY() + distance.getY());
    }

    public void bounce(Vector2f normal, Shape shape) {

        if (lastHit == null || !lastHit.equals(shape)) {

            if (normal.x != 0) {
                speed.set(-speed.getX(), speed.getY());
            }
            if (normal.y != 0) {
                speed.set(speed.getX(), -speed.getY());
            }
            lastHit = shape;
            bounceCounter++;

            if(bounceCounter%20==0){
                this.increaseSpeed();
            }

        }
    }

    public void setBallToCenter(){
        this.setCenterX(Constants.SCREEN_WIDTH/2);
        this.setCenterY(Constants.SCREEN_HEIGHT/2);
    }

    public void resetSpeed(DIRECTION direction){
        int angle;


        lastHit = null;
        if (direction == LEFT) {
            angle = randomGenerator.nextInt(120) - 60;
        } else {
            angle = randomGenerator.nextInt(120) + 120;
        }

        speed = new Vector2f((float) Math.cos(Math.toRadians(angle)) * speedLength, (float) Math.sin(Math.toRadians(angle)) * speedLength);
    }

    private void increaseSpeed(){
        speed=speed.scale(1.20f);
    }

    public enum DIRECTION {
        LEFT, RIGHT
    }
}
