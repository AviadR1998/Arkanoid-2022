// Name: Aviad Ravid
// ID: 209321108
package BasicShapes;

/**
 * The BasicShapes.Point class implements a BasicShapes.Point structure with an x and y variables.
 * @author  Aviad Ravid
 */
public class Point {
    private double x;
    private double y;

    /**
     * This method is used as a constructor to initialize a Point's instance values.
     * @param x - a point variable contains the value of the start of the line.
     * @param y - a point variable contains the value of the end of the line.
     * The method isn't return any value.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method returns the distance between this point and a given one.
     * @param other - a BasicShapes.Point parameter contains the values of the other point
     * @return this method returns a double value.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
    }

    /**
     * This method returns true if this point is equals to the given point.
     * @param other - another BasicShapes.Point to compare with.
     * @return this method returns a boolean value.
     */
    public boolean equals(Point other) {
        final double trashHold = Math.pow(10, -10);
        return (Math.abs(this.x - other.getX()) <= trashHold) && (Math.abs(this.y - other.getY()) <= trashHold);
    }

    /**
     * This method is used to return the x value of this BasicShapes.Point.
     * @return this method returns a double value.
     */
    public double getX() {
        return this.x;
    }

    /**
     * This method is used to return the y value of this BasicShapes.Point.
     * @return this method returns a double value.
     */
    public double getY() {
        return this.y;
    }
}
