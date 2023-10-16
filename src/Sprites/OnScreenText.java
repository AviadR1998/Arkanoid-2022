// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import GameTools.GameLevel;
import biuoop.DrawSurface;

public class OnScreenText implements Sprite {
    private String str;
    private int textX, textY;

    /**
     * This method is used as a constructor to initialize a OnScreenText's instance values.
     *
     * @param str   - a given sstring.
     * @param textX - a given int.
     * @param textY - a given int.
     */
    public OnScreenText(String str, int textX, int textY) {
        this.str = str;
        this.textX = textX;
        this.textY = textY;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(textX, textY, str, 15);
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
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
