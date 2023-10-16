// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import CollisionTypes.Collidable;
import GameTools.GameLevel;
import ListenerPattern.HitListener;
import Logics.Velocity;
import ListenerPattern.HitNotifier;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The Sprites.Block class implements a Sprites.Block structure that implements CollisionTypes.
 * Collidable and Sprites.Sprite interfaces.
 * Sprites.Block got a BasicShapes.Rectangle who the block "made of" and get notified if it got hit.
 *
 * @author Aviad Ravid
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Boolean hitted;
    private Line ballsLine;
    private java.awt.Color color;
    private int sideOfCrash;
    private List<HitListener> hitListeners;

    /**
     * This method is used as a constructor to initialize a Sprites.Block's instance values. with color.
     *
     * @param rect  - a Rectangle variable contains the value of the rectangle the Sprites.Block's "made of".
     * @param color - a java.awt.Color variable contains the color of the block.
     *              The method isn't return any value.
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.hitted = false;
        this.color = color;
        this.sideOfCrash = 1;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * This method is used as a constructor to initialize a Sprites.Block's instance values.
     *
     * @param rect - a BasicShapes.Rectangle variable contains the value of the rectangle the Sprites.Block's "made of".
     *             The method isn't return any value.
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.hitted = false;
        this.color = Color.BLACK;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * This method exists because Block implements Collidable, the Method used to return this instance
     * of Sprites.Block rectangle.
     *
     * @return BasicShapes.Rectangle variable.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * This method used to set the ball of this instance of Blocks BasicShapes.Rectangle.
     * of Sprites.Block rectangle.
     *
     * @param ball - a given Sprites.Ball variable.
     *             this method isn't returns any value.
     */
    public void setBallOfRect(Ball ball) {
        this.rect.setBall(ball);
    }

    /**
     * this method exists because Block implements Collidable class. the method gets a collision point and a velocity
     * and returns an updated velocity of the hitted item by the location of the hit.
     *
     * @param collisionPoint
     * @param currentVelocity
     * @return Logics.Velocity variable
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.hitted = true;
        int indicator = this.sideOfCrash;
        if (indicator == 1 || indicator == 2) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
        }
        if (indicator == 3 || indicator == 4) {
            this.notifyHit(hitter);
            return new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * This method is used to draw the block in the given Drawsurface surface.
     * The method isn't return any value.
     *
     * @param d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    /**
     * This method exist because Block implements Sprite, the Method used to change the Block after the "time passed".
     * simply do nothing for now.
     */
    public void timePassed() {
        return;
    }

    /**
     * This method exist because Block implements Sprite, the Method used to add the block to Sprites List
     * in the given GameTools.Game.
     *
     * @param g - a given GameTools.Game parameter.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This method used to set this Blocks side of collision with a ball.
     * this method isn't return any value
     *
     * @param num - the given number
     */
    public void sideOfCol(int num) {
        this.sideOfCrash = num;
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }


    /**
     * This method updates all the Listeners that a hit occur by calling there's hitEvent method.
     *
     * @param hitter - a given Ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * This mehod removes that instance of Block from a given Game variable.
     *
     * @param game - a given Game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
    }
}
