// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

public class PauseScreen extends KeyPressStoppableAnimation {

    /**
     * This method is used as a constructor to initialize a PauseScreen's instance values.
     *
     * @param k - a KeyboardSensor parameter.
     */
    public PauseScreen(KeyboardSensor k) {
        super(k, KeyboardSensor.SPACE_KEY);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.getHSBColor(0.12f, 0.3f, 88f));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawCircle(400, 250, 80);
        d.drawCircle(400, 250, 90);
        d.drawRectangle(350, 195, 40, 110);
        d.fillRectangle(350, 195, 40, 110);
        d.drawRectangle(410, 195, 40, 110);
        d.fillRectangle(410, 195, 40, 110);
        d.drawText(320, 400, "Paused", 50);
        d.drawText(255, 500, "press space to continue", 30);
        super.doOneFrame(d);
    }
}
