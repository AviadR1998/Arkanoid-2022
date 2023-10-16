// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import biuoop.DrawSurface;

/**
 * The Animation interface set guiding lines to classes that animated something to the screen.
 */
public interface Animation {

    /**
     * Thid method make a one frame change of this animation on the given DrawSurface.
     * @param d - a given DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * This method returns true if the animation shuold stop. Otherwise it returns false.
     * @return - true or false.
     */
    boolean shouldStop();
}