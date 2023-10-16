// Name: Aviad Ravid
// ID: 209321108
package GameTools;

import Logics.Velocity;
import Sprites.Block;
import Sprites.Sprite;

import java.util.List;

public interface LevelInformation {

    /**
     * This mehod returns the number of balls in that level.
     *
     * @return - int.
     */
    int numberOfBalls();


    /**
     * This method returns the initial velocity of each ball.
     *
     * @return - a List<Velocity>.
     */
    List<Velocity> initialBallVelocities();

    /**
     * This method returns the speed of the paddle.
     *
     * @return - an int.
     */
    int paddleSpeed();

    /**
     * This method retrns the Width of the padde.
     *
     * @return - an int.
     */
    int paddleWidth();

    /**
     * This method retorns the name of the level.
     *
     * @return - a String.
     */
    String levelName();


    /**
     * This method Returns a sprite with the background of the level.
     *
     * @return - a Sprite.
     */
    Sprite getBackground();


    /**
     * This method returns the Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return - a List<Block>.
     */
    List<Block> blocks();


    /**
     * This method returns the number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return - an int.
     */
    int numberOfBlocksToRemove();
}