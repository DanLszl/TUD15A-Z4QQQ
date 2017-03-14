package athens.org;

import org.newdawn.slick.geom.Rectangle;

/**
 * Created by Dani on 3/14/2017.
 */
public class Paddle extends Rectangle {

    // TODO left-right
    private double centerPosition;

    Paddle(double centerPosition) {
        super(50, 100, 20, 60);
        this.centerPosition = centerPosition;
    }
}
