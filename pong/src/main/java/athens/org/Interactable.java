package athens.org;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by peter on 16.03.17.
 */
public interface Interactable {
    void interact (Ball ball);
    boolean intersect (Shape shape);

}
