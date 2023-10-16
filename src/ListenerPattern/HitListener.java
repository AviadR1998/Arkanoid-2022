// Name: Aviad Ravid
// ID: 209321108
package ListenerPattern;

import Sprites.Block;
import Sprites.Ball;

/**
 * The HitListener interface is an interface take role on the Listener pattern.
 * Every method that implements HitListener supposed to act as a Listener of a HitNotifier class.
 *
 * @author Aviad Ravid
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * The method role is to update the listener a hit occur.
     *
     * @param beingHit - a given Block.
     * @param hitter   - a given Ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}