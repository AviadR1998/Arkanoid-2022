// Name: Aviad Ravid
// ID: 209321108
package CollisionTypes;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import Logics.Velocity;
import Sprites.Ball;


/**
 * The Collidable interface implements a Collidable item structure that include 3 Methods that every class
 * who implements Collidable got to have. ones who returns the BasicShapes.Rectangle that Collidable made from,
 * second returns the new velocity of an item who hits that collidable and third returns
 * the side of collision with that item.
 *
 * @author Aviad Ravid
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     * unimplemented method. class who implementing CollisionTypes.Collidable must implement that method.
     *
     * @return BasicShapes.Rectangle
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * unimplemented method. class who implementing Collidable must implement that method.
     *
     * @param hitter          - a given Ball.
     * @param collisionPoint  - a given Point.
     * @param currentVelocity - a given Velocity.
     * @return - the new Velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * unimplemented method. class who implementing CollisionTypes.Collidable must implement that method.
     * that method is used to return the side of collision with the collidable instance.
     *
     * @param num - a given int.
     */
    void sideOfCol(int num);

}
