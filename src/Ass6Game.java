// Name: Aviad Ravid
// ID: 209321108

import GameTools.AnimationTools.AnimationRunner;
import GameTools.GameFlow;
import GameTools.Layouts.DirectHitLevel;
import GameTools.Layouts.FinalFourLevel;
import GameTools.Layouts.GreenThreeLevel;
import GameTools.Layouts.WideEasyLevel;
import GameTools.LevelInformation;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;


/**
 * The Ass6Game program implements an application that simply creates a graphic game by a given args.
 * Every given number between 1 and 4 represent a level.
 *
 * @author Aviad Ravid
 */
public class Ass6Game {

    /**
     * This method is used to run the game, by calling this method the game begins in an endless loop.
     * The method isn't return any value.
     *
     * @param levels - a given LevelInformation list.
     */
    public void run(List<LevelInformation> levels) {
        GUI gui = new GUI("Arkanoid 2022", 800, 600);
        GameFlow gf = new GameFlow(new AnimationRunner(gui, 60), gui.getKeyboardSensor());
        if (levels.size() >= 1) {
            gf.runLevels(levels);
        } else {
            List<LevelInformation> levelsDefault = new ArrayList<>();
            levelsDefault.add(new DirectHitLevel());
            levelsDefault.add(new WideEasyLevel());
            levelsDefault.add(new GreenThreeLevel());
            levelsDefault.add(new FinalFourLevel());
            gf.runLevels(levelsDefault);
        }
    }

    /**
     * This is the main method which makes use of run method to start the game.
     *
     * @param args - a given String array contain the asked levels numbers for the game and
     *             their order.
     *             The method isn't return any value.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        for (String str : args) {
            if (str.equals("1")) {
                levels.add(new DirectHitLevel());
            } else if (str.equals("2")) {
                levels.add(new WideEasyLevel());
            } else if (str.equals("3")) {
                levels.add(new GreenThreeLevel());
            } else if (str.equals("4")) {
                levels.add(new FinalFourLevel());
            }
        }
        Ass6Game myGame = new Ass6Game();
        myGame.run(levels);
    }
}
