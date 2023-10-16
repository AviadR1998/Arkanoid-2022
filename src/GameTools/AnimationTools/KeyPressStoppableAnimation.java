// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * This method is used as a constructor to initialize a KeyPressStoppableAnimation's instance values.
     *
     * @param sensor - a KeyboardSensor parameter.
     * @param key    - a String.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key) {
        this.key = key;
        this.sensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }
}

