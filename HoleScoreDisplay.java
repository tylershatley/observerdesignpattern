/**
 * 
 */
package observerdesignpattern;

/**
 * @author tylershatley
 *
 */
public class HoleScoreDisplay implements Observer {
    private Subject golfer;
    private int strokes;
    private int par;

    public HoleScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        golfer.registerObserver(this);
    }

    @Override
    public void update(int strokes, int par) {
        // TODO Auto-generated method stub
        this.strokes = strokes;
        this.par = par;
        displayCurrentScore();
    }

    public void displayCurrentScore() {
        System.out.println("Current Hole stats: \n" +
            "Par: " + par + "\n" +
            "Strokes: " + strokes);
        if (par == strokes) {
            System.out.println("Made par\n");
        } else if (par > strokes) {
            System.out.println((par - strokes) + " under par" + "\n");
        } else if (par < strokes) {
            System.out.println((strokes - par) + " over par" + "\n");
        }
    }
}
