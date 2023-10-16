// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

public class EndScreen extends KeyPressStoppableAnimation {
    private boolean winner;
    private int score;

    /**
     * This method is used as a constructor to initialize a EndScreen's instance values.
     *
     * @param ks     - KeyboardSensor parameter.
     * @param winner - a boolean parameter.
     * @param score  - an int.
     */
    public EndScreen(KeyboardSensor ks, boolean winner, int score) {
        super(ks, KeyboardSensor.SPACE_KEY);
        this.winner = winner;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.getHSBColor(100, 30, 85));
        d.setColor(Color.getHSBColor(0.12f, 0.3f, 88f));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        if (winner) {
            d.drawText(170, d.getHeight() / 2, "You Win!", 120);
            //d.drawText(100, d.getHeight() / 2, "You Win! Your score is: " + this.score, 40);
        } else {
            d.drawText(128, d.getHeight() / 2, "Game Over!", 105);
            //d.drawText(100, d.getHeight() / 2, "Game Over! Your score is: " + this.score, 40);
        }
        d.drawText(210, 375, "Your score is: " + this.score, 50);
        d.drawText(30, 570, "press space to close", 24);
        super.doOneFrame(d);
    }
}
