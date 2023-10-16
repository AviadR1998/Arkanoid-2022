// Name: Aviad Ravid
// ID: 209321108
package GameTools.AnimationTools;

import biuoop.GUI;
import biuoop.DrawSurface;

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * This method is used as a constructor to initialize a AnimationRunner's instance values.
     *
     * @param gui             - given biuoop.GUI
     * @param framesPerSecond - given int represent the frames per second.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * This method runs the Animation on a DrawSurface parameter.
     *
     * @param animation - a given Animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        sleeper.sleepFor(500);
    }

    /**
     * This method returns The Gui of this instance of AnimationRunner.
     *
     * @return - GUI.
     */
    public GUI getGui() {
        return gui;
    }
}
