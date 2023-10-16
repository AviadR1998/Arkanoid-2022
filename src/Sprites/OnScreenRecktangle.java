// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Rectangle;
import GameTools.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

public class OnScreenRecktangle implements Sprite {
    private Rectangle rec;
    private Color color;

    /**
     * This method is used as a constructor to initialize a OnScreenRecktangle's instance values.
     *
     * @param rec   - a given Rectangle.
     * @param color - a given color.
     */
    public OnScreenRecktangle(Rectangle rec, Color color) {
        this.rec = rec;
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) this.rec.getLeftL().start().getX(), (int) rec.getLeftL().start().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
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
