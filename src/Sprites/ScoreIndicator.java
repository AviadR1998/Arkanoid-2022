// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Rectangle;
import GameTools.GameLevel;
import Logics.Counter;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The ScoreIndicator Class implements sprite interface.
 * This class makes an indicator to a score in a game and adds it to a given game.
 *
 * @author Aviad Ravid
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rect;
    private Counter currentScore;
    private java.awt.Color color;

    /**
     * This method is used as a constructor to initialize a ScoreIndicator's instance values.
     *
     * @param rect         - a given Rectangle
     * @param currentScore - a given Counter.
     */
    public ScoreIndicator(Rectangle rect, Counter currentScore) {
        this.rect = rect;
        this.currentScore = currentScore;
        this.color = Color.white;
    }

    /**
     * This method is used as a constructor to initialize a ScoreIndicator's instance values.
     *
     * @param rect         - a given Rectangle
     * @param currentScore - a given Counter.
     * @param color        - a given Color.
     */
    public ScoreIndicator(Rectangle rect, Counter currentScore, java.awt.Color color) {
        this.rect = rect;
        this.currentScore = currentScore;
        this.color = color;
    }

    /**
     * This method used to draw the sprite on the screen.
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
        String str = "Score : " + this.currentScore.getValue();
        d.drawText((int) (this.rect.getUpperLeft().getX() + (this.rect.getWidth() / 2) - 20),
                (int) (this.rect.getUpperLeft().getY() + 14),
                str, 15);
    }


    /**
     * This method is used to notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }

    /**
     * This mehod adds this instance of ScoreIndicator to a given game.
     *
     * @param g - a given game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * This method returns the rectangle that on top of it the score is written.
     *
     * @return - a Rectangle.
     */
    public Rectangle getRect() {
        return rect;
    }
}
