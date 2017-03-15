package athens.org;

/**
 * Created by peter on 15.03.17.
 */
public interface Subject {

    void registerObserver(Observer observer);
    void scoreChanged();
    String getScores();
}