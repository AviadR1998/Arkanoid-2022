// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Line;
import GameTools.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

public class OnScreenLine implements Sprite {
    private Line l;
    private Color color;

    /**
     * This method is used as a constructor to initialize a OnScreenLine's instance values.
     *
     * @param l     - a given Line.
     * @param color - a given color.
     */
    public OnScreenLine(Line l, Color color) {
        this.l = l;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.drawLine((int) this.l.start().getX(), (int) l.start().getY(), (int) l.end().getX(), (int) l.end().getY());
    }


    @Override
    public void timePassed() {
        return;
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
