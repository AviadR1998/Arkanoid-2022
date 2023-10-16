// Name: Aviad Ravid
// ID: 209321108
package ListenerPattern;

/**
 * a HitNotifies is part of the Listener pattern. every class that implements this
 * should act as a Notifier to a Listeners that are listed as ones.
 *
 * @author Aviad Ravid
 */
public interface HitNotifier {
    // Add hl as a listener to hit events.

    /**
     * This method adds hl as a listener to hit events.
     *
     * @param hl - a given Listener.
     */
    void addHitListener(HitListener hl);

    /**
     * This method Removes hl from the list of listeners to hit events.
     *
     * @param hl - a given Listener.
     */
    void removeHitListener(HitListener hl);
}