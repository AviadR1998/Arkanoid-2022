// Name: Aviad Ravid
// ID: 209321108
package BasicShapes;

import java.util.List;

/**
 * The BasicShapes.Line class implements a BasicShapes.Line structure with a start point and end point.
 * also steepness value saved as a double called m.
 *
 * @author Aviad Ravid
 */
public class Line {
    private Point start;
    private Point end;
    private double steepness;
    private double equationConst;

    /**
     * This method is used as a constructor to initialize a line's instance values.
     *
     * @param start - a point variable contains the value of the start of the line.
     * @param end   - a point variable contains the value of the end of the line.
     *              The method isn't return any value.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        if ((this.start.getX() == this.end.getX()) || (this.start.getY() == this.end.getY())) {
            this.steepness = 0;
        } else {
            this.steepness = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
        this.equationConst = (-this.steepness * this.end.getX()) + this.end.getY();
    }

    /**
     * This method is used as a constructor to initialize a line's instance values.
     *
     * @param x1 - a double variable contains the x value of the start point.
     * @param y1 - a double variable contains the y value of the start point.
     * @param x2 - a double variable contains the x value of the end point.
     * @param y2 - a double variable contains the y value of the end point.
     *           The method isn't return any value.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        if ((this.start.getX() == this.end.getX()) || (this.start.getY() == this.end.getY())) {
            this.steepness = 0;
        } else {
            this.steepness = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
        this.equationConst = (-this.steepness * this.end.getX()) + this.end.getY();
    }

    /**
     * This method is used to return the length of this line.
     *
     * @return this method returns a double value.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * This method is used to return a point contains the value of the middle point of the line.
     *
     * @return this method returns a BasicShapes.Point variable.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * This method is used to return a point contains the value of the start point of the line.
     *
     * @return this method returns a BasicShapes.Point variable.
     */
    public Point start() {
        return this.start;
    }

    /**
     * This method is used to return a point contains the value of the end point of the line.
     *
     * @return this method returns a BasicShapes.Point variable.
     */
    public Point end() {
        return this.end;
    }

    /**
     * This method is used to return the steepness of this line.
     *
     * @return this method returns a double value.
     */
    public double getSteepness() {
        return this.steepness;
    }

    /**
     * This method returns true if this line is intersecting with the given line.
     *
     * @param other - another BasicShapes.Line to compare with.
     * @return this method returns a boolean value.
     */
    public boolean isIntersecting(Line other) {
        if (this.start.getX() == this.end.getX()) {
            if (other.start.getX() == other.end.getX()) {
                if (other.start.getX() != this.start.getX()) {
                    return false;
                } else if
                (Math.max(this.start.getY(), this.end.getY()) >= Math.max(other.start.getY(), other.end.getY())) {
                    return Math.min(this.start.getY(), this.end.getY())
                            <= Math.max(other.start.getY(), other.end.getY());
                } else {
                    return Math.min(this.start.getY(), this.end.getY())
                            >= Math.min(other.start.getY(), other.end.getY());
                }
            }
            if (Math.min(other.start().getX(), other.end.getX()) <= this.end.getX()
                    && Math.max(other.start.getX(), other.end.getX()) >= this.end.getX()) {
                if (Math.min(other.start.getY(), other.end.getY()) <= Math.max(this.start().getY(), this.end().getY())
                        && Math.max(other.start.getY(), other.end.getY())
                        >= Math.min(this.start().getY(), this.end.getY())) {
                    return true;
                }
            }
            return false;
        }
        if (other.start.getX() == other.end.getX()) {
            if (this.start.getX() == this.end.getX()) {
                if (this.start.getX() != other.start.getX()) {
                    return false;
                } else if
                (Math.max(other.start.getY(), other.end.getY()) >= Math.max(this.start.getY(), this.end.getY())) {
                    return Math.min(other.start.getY(), other.end.getY())
                            <= Math.max(this.start.getY(), this.end.getY());
                } else {
                    return Math.min(other.start.getY(), other.end.getY())
                            >= Math.min(this.start.getY(), this.end.getY());
                }
            }
            if (Math.min(this.start().getX(), this.end.getX()) <= other.end.getX()
                    && Math.max(this.start.getX(), this.end.getX()) >= other.end.getX()) {
                if (Math.min(this.start.getY(), this.end.getY()) <= Math.max(other.start().getY(), other.end().getY())
                        && Math.max(this.start.getY(), this.end.getY())
                        >= Math.min(other.start().getY(), other.end.getY())) {
                    return true;
                }
            }
            return false;
        }
        if (this.getSteepness() == 0) {
            if (other.getSteepness() == 0) {
                if (other.end.getY() != this.end.getY()) {
                    return false;
                }
                return intersectionOfYParallel(other);
            }
            if (Math.min(other.start.getY(), other.end.getY()) <= this.end.getY()
                    && Math.max(other.start.getY(), other.end.getY()) >= this.end.getY()) {
                if (Math.min(other.start.getX(), other.end.getX()) <= Math.max(this.start.getX(), this.end.getX())
                        && Math.max(other.start.getX(), other.end.getX())
                        >= Math.min(this.start.getX(), this.end.getX())) {
                    return true;
                }
            }
            return false;
        }
        if (other.getSteepness() == 0) {
            if (this.getSteepness() == 0) {
                if (this.end.getY() != other.end.getY()) {
                    return false;
                }
                return intersectionOfYParallel(other);
            }
            if (Math.min(this.start.getY(), this.end.getY()) <= other.end.getY()
                    && Math.max(this.start.getY(), this.end.getY()) >= other.end.getY()) {
                if (Math.min(this.start.getX(), this.end.getX()) <= Math.max(other.start.getX(), other.end.getX())
                        && Math.max(this.start.getX(), this.end.getX())
                        >= Math.min(other.start.getX(), other.end.getX())) {
                    return true;
                }
            }
            return false;
        }
        if (this.getSteepness() == other.getSteepness()) {
            return intersectionOfYParallel(other);
        }
        double func1 = (-this.steepness) * (this.start.getX()) + (this.start.getY());
        double func2 = (-other.getSteepness()) * (other.start.getX()) + (other.start.getY());
        double intersectX = (func2 - func1) / (this.steepness - other.getSteepness());
        return (intersectX <= Math.max(this.start.getX(), this.end.getX())
                && intersectX >= Math.min(this.start.getX(), this.end.getX()))
                && ((intersectX <= Math.max(other.start.getX(), other.end.getX())
                && intersectX >= Math.min(other.start.getX(), other.end.getX())));
    }

    /**
     * This method returns true if this line is parallel and intersecting with the given line.
     *
     * @param other - another BasicShapes.Line to compare with.
     * @return this method returns a boolean value.
     */
    private boolean intersectionOfYParallel(Line other) {
        return (Math.max(this.start.getX(), this.end.getX()) >= Math.max(other.start.getX(), other.end.getX())
                && Math.max(other.start.getX(), other.end.getX()) >= Math.min(this.start.getX(), this.end.getX()))
                || (Math.max(this.start.getX(), this.end.getX()) <= Math.max(other.start.getX(), other.end.getX())
                && Math.max(this.start.getX(), this.end.getX()) >= Math.min(other.start.getX(), other.end.getX()));
    }

    private boolean onePointIntersectionX(Line other) {
        if (Math.max(this.start.getY(), this.end.getY()) == Math.min(other.start.getY(), other.end.getY())) {
            return true;
        }
        return Math.max(other.start.getY(), other.end.getY()) == Math.min(this.start.getY(), this.end.getY());
    }

    private boolean onePointIntersectionY(Line other) {
        if (Math.max(this.start.getX(), this.end.getX()) == Math.min(other.start.getX(), other.end.getX())) {
            return true;
        }
        return Math.max(other.start.getX(), other.end.getX()) == Math.min(this.start.getX(), this.end.getX());
    }

    /**
     * This method returns the point of intersection between this line and the given line.
     * if the two lines aren't intersecting the method returns a null value.
     *
     * @param other - another BasicShapes.Line to compare with.
     * @return this method returns a BasicShapes.Point value.
     */
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other) || this.equals(other)) {
            return null;
        }
        double newX, newY;
        if (this.start.getX() == this.end.getX()) {
            if (other.start.getX() == other.end.getX()) {
                if (other.start.getX() == other.end.getX()) {
                    if (!this.onePointIntersectionX(other)) {
                        return null;
                    }
                }
            }
            newX = this.start.getX();
            if (other.start.getX() == other.end.getX()) {
                if (Math.max(this.start.getY(), this.end.getY()) > Math.max(other.start.getY(), other.end.getY())) {
                    if
                    (Math.min(this.start.getY(), this.end.getY()) != Math.max(other.start.getY(), other.end.getY())) {
                        return null;
                    }
                } else if
                (Math.min(this.start.getY(), this.end.getY()) != Math.max(this.start.getY(), this.end.getY())) {
                    return null;
                }
                newY = Math.max(Math.min(this.start.getY(),
                        this.end.getY()), Math.min(other.start.getY(), other.end.getY()));
                return new Point(newX, newY);
            }
            newY = (other.getSteepness()) * newX - (other.getSteepness()) * other.end.getX() + other.end.getY();
            return new Point(newX, newY);
        }
        if (other.start.getX() == other.end.getX()) {
            newX = other.start.getX();
            newY = (this.getSteepness()) * newX - (this.getSteepness()) * this.end.getX() + this.end.getY();
            return new Point(newX, newY);
        }
        if (this.equationConst == other.equationConst && this.steepness == other.steepness) {
            if (!onePointIntersectionY(other)) {
                return null;
            }
        }
        if (this.getSteepness() == other.getSteepness() && this.getSteepness() == 0) {
            if (this.start.getX() == other.start.getX() || this.start.getX() == other.end.getX()) {
                newX = this.start.getX();
            } else {
                newX = this.end.getX();
            }
        } else {
            if (this.getSteepness() == 0) {
                newX = (-other.getSteepness() * other.end().getX() + other.end().getY() - this.end().getY())
                        / -other.getSteepness();
            } else if (other.getSteepness() == 0) {
                newX = (-this.getSteepness() * this.end().getX() + this.end().getY() - other.end().getY())
                        / -this.getSteepness();
            } else {
                newX = (-other.getSteepness() * other.end.getX() + other.end.getY() + this.getSteepness()
                        * this.end.getX() - this.end.getY()) / (this.getSteepness() - other.getSteepness());
            }
        }
        newY = this.getSteepness() * newX - this.getSteepness() * this.end.getX() + this.end.getY();
        return new Point(newX, newY);
    }

    /**
     * This method returns true if this line is equal to the given line.
     *
     * @param other - another BasicShapes.Line to compare with.
     * @return this method returns a boolean value.
     */
    public boolean equals(Line other) {
        return (Math.max(this.start.getX(), this.end.getX()) == Math.max(other.start.getX(), other.end.getX()))
                && (Math.min(this.start.getX(), this.end.getX()) == Math.min(other.start.getX(), other.end.getX()));
    }

    /**
     * That method gets a Rectangle and returns the closest collision point between the rectangle and the line.
     *
     * @param rect - the given rectangle
     * @return BasicShapes.Point, if there is no intersection the method returns null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = rect.intersectionPoints(new Line(this.start, this.end));
        if (points == null) {
            return null;
        }
        Point closerP = points.get(0);
        double smallestD = closerP.distance(this.start);
        double currD;
        for (Point p : points) {
            currD = p.distance(this.start);
            if (currD < smallestD) {
                smallestD = currD;
                closerP = p;
            }
        }
        return closerP;
    }
}
