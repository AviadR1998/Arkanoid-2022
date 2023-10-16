// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import GameTools.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

public class Backgroud implements Sprite {
    private SpriteCollection sprites;
    private Block backgroundColor;

    /**
     * This method is used as a constructor to initialize a Backgroud's instance values.
     *
     * @param color    - a given color parameter.
     * @param givenSpr - a given List<Sprite>.
     */
    public Backgroud(Color color, List<Sprite> givenSpr) {
        this.backgroundColor = new Block(new Rectangle(new Point(0, 0), 800, 600), color);
        this.sprites = new SpriteCollection();
        sprites.addSprite(backgroundColor);
        for (Sprite sprite : givenSpr) {
            this.sprites.addSprite(sprite);
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        sprites.drawAllOn(d);
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

