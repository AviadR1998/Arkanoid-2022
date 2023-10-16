// Name: Aviad Ravid
// ID: 209321108
package ListenerPattern;

import Logics.Counter;
import Sprites.Block;
import Sprites.Ball;

/**
 * This mehod implements HitListener and keep track of the score in a game by a given Counter variable.
 *
 * @author Aviad Ravid
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * This method is used as a constructor to initialize a ScoreTrackingListener's instance values.
     *
     * @param scoreCounter - a given Counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}