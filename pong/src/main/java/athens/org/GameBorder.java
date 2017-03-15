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
        upperBound = new Line(new Vector2f(0,0),        new Vector2f(width, 0));
        lowerBound = new Line(new Vector2f(0,height),   new Vector2f(width, height));
        rightBound = new Line(new Vector2f(width, 0),   new Vector2f(width, height));
        leftBound =  new Line(new Vector2f(0,0),        new Vector2f(0, 480));
    }

    public boolean intersect(Shape shape, BorderType border)
    {
        switch (border){
            case Upper: return upperBound.intersects(shape);
            case Lower: return lowerBound.intersects(shape);
            case Right: return rightBound.intersects(shape);
            case Left:  return leftBound.intersects(shape);
            default:    return false;
        }
    }


    public Line getUpperBound() {
        return upperBound;
    }

    public Line getLowerBound() {
        return lowerBound;
    }


    public enum BorderType{
        Upper, Lower, Right, Left
    }
}

