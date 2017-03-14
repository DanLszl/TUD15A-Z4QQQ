package athens.org;

import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Created by bdaniel on 2017.03.14..
 */
public class GameBorder{

    private Line upperBound;
    private Line lowerBound;
    private Line rightBound;
    private Line leftBound;

    public GameBorder(float width, float height){
        upperBound = new Line(new Vector2f(0,0), new Vector2f(640, 0));
        lowerBound = new Line(new Vector2f(0,480), new Vector2f(640, 480));
        rightBound = new Line(new Vector2f(640, 0), new Vector2f(640, 480));
        leftBound = new Line(new Vector2f(0,0), new Vector2f(0, 480));
    }

    public boolean intersectUpper(Shape shape){

        return upperBound.intersects(shape);
    }

    public boolean intersectLower(Shape shape){

        return lowerBound.intersects(shape);
    }

    public boolean intersectRight(Shape shape) {

        return rightBound.intersects(shape);
    }

    public boolean intersectLeft(Shape shape){

        return leftBound.intersects(shape);
    }
}
