// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import Sprites.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

// The GameTools.AnimationTools.CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSecounds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int updatedCounter;

    /**
     * This method is used as a constructor to initialize a CountdownAnimation's instance values.
     *
     * @param numOfSeconds - given int.
     * @param countFrom    - given int.
     * @param gameScreen   - given SpriteCollection.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSecounds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.updatedCounter = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.getHSBColor(0.99f, 0.99f, 180));
        d.setColor(Color.getHSBColor(0.12f, 0.3f, 88f));
        d.drawText(d.getWidth() / 2 - 130, d.getHeight() / 2 + 50, " " + this.updatedCounter + " ",
                250);
        Sleeper sleeper = new Sleeper();
        if (this.updatedCounter != this.countFrom) {
            sleeper.sleepFor((long) ((numOfSecounds / countFrom) * 1000));
        }
        this.updatedCounter = this.updatedCounter - 1;
    }

    @Override
    public boolean shouldStop() {
        return this.updatedCounter <= 0;
    }
}