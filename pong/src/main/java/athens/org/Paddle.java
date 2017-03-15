package athens.org;

import org.newdawn.slick.geom.RoundedRectangle;

import static athens.org.Constants.*;

/**
 * Created by Dani on 3/14/2017.
 */
public class Paddle extends RoundedRectangle {

    public Paddle(float x) {
        super(x, PADDLE_Y_COORD, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_CORNER_RADIUS);
    }

}