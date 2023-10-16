// Name: Aviad Ravid
// ID: 209321108
package ListenerPattern;

import GameTools.GameLevel;
import Logics.Counter;
import Sprites.Block;
import Sprites.Ball;


/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Aviad Ravid
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * This method is used as a constructor to initialize a BallRemover's instance values.
     *
     * @param game           - a given Game variable.
     * @param remainingBalls - a given Counter variable.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
