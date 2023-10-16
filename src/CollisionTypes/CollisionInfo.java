// Name: Aviad Ravid
// ID: 209321108
package CollisionTypes;

import BasicShapes.Point;


/**
 * The CollisionTypes.CollisionInfo class implements a class which every of its instances
 * contain data about one collision. the data is a BasicShapes.
 * Point of collision and variable represent the collision object.
 *
 * @author Aviad Ravid
 */
public class CollisionInfo {
    private Point colPoint;
    private Collidable colObject;

    /**
     * This method is used as a constructor to initialize a CollisionTypes.CollisionInfo's instance values.
     *
     * @param colPoint
     * @param colObject
     */
    public CollisionInfo(Point colPoint, Collidable colObject) {
        this.colObject = colObject;
        this.colPoint = colPoint;
    }

    /**
     * This method is used to return to the point at which the collision occurred on.
     *
     * @return this method returns a point value.
     */
    public Point collisionPoint() {
        return this.colPoint;
    }

    /**
     * This method is used to return to the object with whom the collision occurred.
     *
     * @return this method returns a CollisionTypes.Collidable value.
     */
    public Collidable collisionObject() {
        return this.colObject;
    }
}
