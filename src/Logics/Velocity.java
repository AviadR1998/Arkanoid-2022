// Name: Aviad Ravid
// ID: 209321108
package Logics;

import BasicShapes.Point;

/**
 * The Logics.Velocity class implements a Logics.Velocity structure with dx and dy variables.
 * dx contains the change of the X-axis, dy contains the change of the Y-axis.
 *
 * @author Aviad Ravid
 */
public class Velocity {
    private double dx = 1;
    private double dy = 1;

    /**
     * This method is used as a constructor to initialize a Logics.Velocity's instance values.
     *
     * @param dx - a double variable contains the change of the X-axis.
     * @param dy - a double variable contains the change of the Y-axis.
     *           The method isn't return any value.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This method gets an angle and speed of the ball and converts it into x and y change
     * of velocity.
     *
     * @param angle - a double variable contains the angle the ball moves toward.
     * @param speed - a double variable contains the speed of the ball.
     * @return a velocity variable contains the dx and dy changes.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dyChange = -Math.cos(Math.toRadians(angle)) * speed, dxChange = Math.sin(Math.toRadians(angle)) * speed;
        Velocity v = new Velocity(dxChange, dyChange);
        return v;
    }

    /**
     * This method gets a point and returns an updated point with the changes in x and y by the instance velocity.
     *
     * @param p - a point variable.
     * @return an updated BasicShapes.Point variable.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }

    /**
     * This method returns the Dx value of this Logics.Velocity.
     *
     * @return this method returns a double value.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This method returns the Dy value of this Logics.Velocity.
     *
     * @return this method returns a double value.
     */
    public double getDy() {
        return this.dy;
    }
}
