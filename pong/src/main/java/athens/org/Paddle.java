package athens.org;

import org.newdawn.slick.geom.RoundedRectangle;

/**
 * Created by Dani on 3/14/2017.
 */
public class Paddle extends RoundedRectangle {

    private int score=0;


    public Paddle(float x) {
        super(x, 100, 20, 60, 8);
    }

    public int getScore(){
        return score;
    }

    public void incScore(){
        score++;
    }
}