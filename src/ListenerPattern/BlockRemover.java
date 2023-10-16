// Name: Aviad Ravid
// ID: 209321108
package ListenerPattern;

import GameTools.GameLevel;
import Logics.Counter;
import Sprites.Block;
import Sprites.Ball;

// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Aviad Ravid
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * This method is used as a constructor to initialize a BlockRemover's instance values.
     *
     * @param game          - a given Game variable.
     * @param removedBlocks - a given Counter variable.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}
