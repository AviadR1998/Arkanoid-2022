// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import CollisionTypes.Collidable;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The SpriteCollection class implements a class which every of its instances contain a list of Sprites.
 *
 * @author Aviad Ravid
 */
public class SpriteCollection {
    private List<Sprite> sprList;

    /**
     * This method is used as a constructor to initialize the list of sprites with null.
     */
    public SpriteCollection() {
        this.sprList = new ArrayList<Sprite>();
    }

    /**
     * This method is used to add Sprites.Sprite to the List.
     *
     * @param s - a Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprList.add(s);
    }

    /**
     * This method is used to remove Sprites.Sprite from the List.
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprList.remove(s);
    }

    /**
     * This method removes a given Collidable from this instance of SpriteCollection's list.
     *
     * @param c - a given Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.sprList.remove(c);
    }

    // call timePassed() on all sprites.

    /**
     * This method calls the timePassed() of all sprites in the List.
     */
    public void notifyAllTimePassed() {
        List<Sprite> tempSprites = new ArrayList<Sprite>(this.sprList);
        for (Sprite spr : tempSprites) {
            spr.timePassed();
        }
    }

    // call drawOn(d) on all sprites.

    /**
     * This method call drawOn(d) on all sprites in the list.
     *
     * @param d - the given drawSurface to send every drawOn method.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite spr : sprList) {
            spr.drawOn(d);
        }
    }
}
