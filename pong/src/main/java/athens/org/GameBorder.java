package athens.org;

import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bdaniel on 2017.03.14..
 */
public class GameBorder{

    ArrayList<Interactable> borderElementList=new ArrayList<>();

    public GameBorder(float width, float height){
        borderElementList.add(new BorderElement(new Vector2f(0,0), new Vector2f(width, 0)));
        borderElementList.add(new BorderElement(new Vector2f(0,height),   new Vector2f(width, height)));
        borderElementList.add(new RightGoalElement(new Vector2f(width, 0),   new Vector2f(width, height), "PLAYER 1"));
        borderElementList.add(new LeftGoalElement(new Vector2f(0,0), new Vector2f(0, 480), "PLAYER 2"));
    }

    public Iterator<Interactable> getIterator(){
        return borderElementList.iterator();
    }

    public Interactable getUpperBorder(){
        return borderElementList.get(0);
    }

    public Interactable getLowBorder(){
        return borderElementList.get(1);
    }
}

