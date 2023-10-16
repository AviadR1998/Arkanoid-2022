// Name: Aviad Ravid
// ID: 209321108
package BasicShapes;

import Sprites.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * The Rectangle class implements a Rectangle structure by a start upperLeft point, width and height.
 *
 * @author Aviad Ravid
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;
    private Line leftL, rightL, topL, buttomL, ballsLine;
    private Ball ball;

    /**
     * This method is used as a constructor to initialize a line's instance values.
     *
     * @param upperLeft
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.topL = new Line(this.upperLeft, new Point(this.upperLeft.getX() + width, this.upperLeft.getY()));
        this.buttomL = new Line(new Point(this.upperLeft.getX(), this.upperLeft.getY() + height),
                new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height));
        this.leftL = new Line(this.upperLeft, new Point(this.upperLeft.getX(), this.upperLeft.getY() + height));
        this.rightL = new Line(new Point(this.upperLeft.getX() + width, this.upperLeft.getY()),
                new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height));
    }

    /**
     * This method is used to return the height of the rectangle.
     *
     * @return double value
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * This method is used to return the width of the rectangle.
     *
     * @return double value
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * This method is used to return the upper left point of the rectangle.
     *
     * @return BasicShapes.Point parameter
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * This method is used to return the upper left BasicShapes.Line of the rectangle.
     *
     * @return BasicShapes.Line parameter
     */
    public Line getLeftL() {
        return leftL;
    }

    /**
     * This method is used to return the buttom BasicShapes.Line of the rectangle.
     *
     * @return BasicShapes.Line parameter
     */
    public Line getButtomL() {
        return buttomL;
    }

    /**
     * This method is used to return the right BasicShapes.Line of the rectangle.
     *
     * @return BasicShapes.Line parameter
     */
    public Line getRightL() {
        return rightL;
    }

    /**
     * This method is used to return the top BasicShapes.Line of the rectangle.
     *
     * @return BasicShapes.Line parameter
     */
    public Line getTopL() {
        return topL;
    }

    /**
     * This method is used to set the ball variable of this instance of rectangle.
     *
     * @param ball - the given ball
     */
    public void setBall(Ball ball) {
        this.ball = ball;
    }

    /**
     * This method is used to set the ballsLine variable of this instance of rectangle.
     *
     * @param ballsLine - the given line parameter.
     */
    public void setBallsLine(Line ballsLine) {
        this.ballsLine = ballsLine;
    }

    /**
     * This method is used to return the list of intersection points between the given line to the rectangle.
     *
     * @param line - the given line
     * @return List of points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<Point>();
        Point tempP = line.intersectionWith(this.topL);
        if (tempP != null) {
            intersections.add(tempP);
        }
        tempP = line.intersectionWith(this.buttomL);
        if (tempP != null) {
            intersections.add(tempP);
        }
        tempP = line.intersectionWith(this.leftL);
        if (tempP != null) {
            intersections.add(tempP);
        }
        tempP = line.intersectionWith(this.rightL);
        if (tempP != null) {
            intersections.add(tempP);
        }
        if (intersections.size() == 0) {
            return null;
        }
        return intersections;
    }
}
