/**
 * 
 */
package observerdesignpattern;

/**
 * @author tylershatley
 *
 */
public class RoundScoreDisplay implements Observer {
    Subject golfer;
    int strokesTotal;
    int parTotal;

    public RoundScoreDisplay(Subject golfer) {
        this.golfer = golfer;
        golfer.registerObserver(this);
    }

    @Override
    public void update(int strokes, int par) {
        // TODO Auto-generated method stub
        strokesTotal += strokes;
        parTotal += par;

        displayRoundScore();
    }

    public void displayRoundScore() {
        System.out.println("Round stats: \n" +
            "Par: " + parTotal + "\n" +
            "Strokes: " + strokesTotal);
        if (parTotal == strokesTotal) {
            System.out.println("Made par\n");
        } else if (parTotal > strokesTotal) {
            System.out.println((parTotal - strokesTotal) + " under par\n");
        } else if (parTotal < strokesTotal) {
            System.out.println((strokesTotal - parTotal) + " over par\n");
        }
    }
}