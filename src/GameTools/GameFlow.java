// Name: Aviad Ravid
// ID: 209321108
package GameTools;

import GameTools.AnimationTools.AnimationRunner;
import GameTools.AnimationTools.EndScreen;
import Logics.Counter;
import biuoop.KeyboardSensor;

import java.util.List;

public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;

    /**
     * This method is used as a constructor to initialize a GameFlow's instance values.
     *
     * @param ar - an AnimationRunner parameter.
     * @param ks - a KeyboardSensor parameter.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
    }

    /**
     * This method display the given levelInformation's levels to the screen on by one.
     *
     * @param levels - a given LevelInformation List.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean flagWin = true;
        Counter score = new Counter(0);
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, score);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }

            if (level.getReaminingBalls() <= 0) {
                flagWin = false;
                break;
            }

        }
        EndScreen endScr = new EndScreen(this.ks, flagWin, score.getValue());
        this.ar.run(endScr);
        this.ar.getGui().close();
    }
}