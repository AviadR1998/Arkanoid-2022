// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import GameTools.GameLevel;
import biuoop.DrawSurface;

/**
 * The Sprite interface implementing a generic structure of an on screen objects.
 *
 * @author Aviad Ravid
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * This method used to draw the sprite on the screen.
     *
     * @param d - a DrawSurface.
     */
    void drawOn(DrawSurface d);


    /**
     * This method is used to notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * the Method used to add the Sprite to the Sprites List
     * in the given Game.
     *
     * @param g - a given GameTools.Game parameter.
     */
    void addToGame(GameLevel g);

    /**
     * This mehod removes that instance of Sprite from a given Game variable.
     *
     * @param game - a given Game.
     */
    void removeFromGame(GameLevel game);
}