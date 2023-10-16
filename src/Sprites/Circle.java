// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import GameTools.GameLevel;
import biuoop.DrawSurface;
import BasicShapes.Point;

import java.awt.Color;

public class Circle implements Sprite {
    private Point middle;
    private Color color;
    private int radius;
    private boolean fiilMe;
    private Color insideColor;

    /**
     * This method is used as a constructor to initialize a Circle's instance values.
     *
     * @param middle - a given Point.
     * @param radius a given int.
     * @param color  - a given color.
     */
    public Circle(Point middle, int radius, Color color) {
        this.middle = middle;
        this.color = color;
        this.radius = radius;
        this.fiilMe = false;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (fiilMe) {
            d.setColor(this.insideColor);
            d.fillCircle((int) (middle.getX()), (int) (middle.getY()), radius);
        }
        d.setColor(this.color);
        d.drawCircle((int) (middle.getX()), (int) (middle.getY()), radius);
    }

    @Override
    public void timePassed() {
        return;
    }

    /**
     * This method colored the inside part of the circle.
     *
     * @param color
     */
    public void fillTheCircle(Color color) {
        this.insideColor = color;
        this.fiilMe = true;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
