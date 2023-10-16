// Name: Aviad Ravid
// ID: 209321108
package GameTools;

import BasicShapes.Line;
import BasicShapes.Point;
import CollisionTypes.Collidable;
import CollisionTypes.CollisionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * The GameEnvironment class implements a class which every of its instances contain data about one Game.
 * the data is a list of collidables items which on the GUI screen.
 *
 * @author Aviad Ravid
 */
public class GameEnvironment {
    private List<Collidable> obstacles;

    /**
     * This method is used as a constructor to initialize a GameTools.GameEnvironment's instance values.
     * initalizing the list of collidables.
     */
    public GameEnvironment() {
        obstacles = new ArrayList<Collidable>();
    }

    /**
     * That method is used to add a collidable item to the GameTools.Game environment instance.
     *
     * @param col
     */
    public void addCollidable(Collidable col) {
        this.obstacles.add(col);
    }

    /**
     * That method is used to add a return the info about the closest colldable item the given line crosses.
     * if the line isn't cross any of the collidables in the list the method returns null.
     *
     * @param trajectory - the given line
     * @return CollisionTypes.CollisionInfo - the info about the collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closePnt = null, tempPnt;
        CollisionInfo nearestCol = null;
        for (Collidable col : obstacles) {
            tempPnt = trajectory.closestIntersectionToStartOfLine(col.getCollisionRectangle());
            if (tempPnt != null) {
                if (closePnt == null) {
                    closePnt = tempPnt;
                    nearestCol = new CollisionInfo(tempPnt, col);
                } else if (trajectory.start().distance(closePnt) > trajectory.start().distance(tempPnt)) {
                    closePnt = tempPnt;
                    nearestCol = new CollisionInfo(tempPnt, col);
                }
            }
        }
        return nearestCol;
    }

    /**
     * This method removes a given Collidable from this instance of gameEnvironment.
     *
     * @param c - a given Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.obstacles.remove(c);
    }
}
