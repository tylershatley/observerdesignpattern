
package observerdesignpattern;
import java.util.ArrayList;
/**
 * @author tylershatley
 *
 */
public class Golfer implements Subject {
    private ArrayList <Observer> observers;
    private String name;
    private int par;
    private int strokes;

    public Golfer(String name) {
        observers = new ArrayList <Observer> ();
        this.name = name;
    }

    @Override
    public void registerObserver(Observer observer) {
        // TODO Auto-generated method stub
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        // TODO Auto-generated method stub
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int strokes, int par) {
        // TODO Auto-generated method stub
        for (Observer observer: observers) {
            observer.update(strokes, par);
        }
    }

    public void enterScore(int strokes, int par) {
        this.strokes = strokes;
        this.par = par;
        notifyObservers(this.strokes, this.par);
    }

    public String getName() {
        return this.name;
    }
}
