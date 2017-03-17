package athens.org;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by peter on 16.03.17.
 */
public class BorderElement extends Line implements Interactable {


    public BorderElement(Vector2f start, Vector2f end) {
        super(start, end);
    }

    @Override
    public void interact(Ball ball) {

        if(ball.intersects(this))
            ball.bounce(new Vector2f(0, -1), this);
    }

    @Override
    public boolean intersect(Shape shape) {
        return shape.intersects(this);
    }


}
