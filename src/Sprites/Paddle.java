// Name: Aviad Ravid
// ID: 209321108
package Sprites;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import CollisionTypes.Collidable;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

import Logics.Velocity;
import GameTools.GameLevel;

/**
 * The Paddle class implements a Paddle structure that implements Collidable and Sprite interfaces.
 * Sprites.Paddle got a BasicShapes.Rectangle who the paddle "made of" and get notified if it got hit.
 *
 * @author Aviad Ravid
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private int sideOfCrash;
    private Color color;
    private double rightBoarder, leftBoarder;
    private Ball ball;
    private double speed;

    /**
     * This method is used as a constructor to initialize a line's instance values.
     * The method gets a KeyboardSensor and initalize all the paddle parameters to default.
     *
     * @param keyboard - a KeyboardSensor.
     */
    public Paddle(biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        rect = new Rectangle(new Point(380, 520), 50, 10);
        rightBoarder = 800;
        leftBoarder = 0;
        this.color = Color.black;
        this.speed = 5;
    }

    /**
     * This method is used as a constructor to initialize a line's instance values.
     * The method gets a KeyboardSensor, BasicShapes.Point, Color, width and height parameters and initalize
     * all the paddle parameters by the given values.
     *
     * @param keyboard - a KeyboardSensor.
     * @param start    - a Point.
     * @param width    - a double.
     * @param height   - a double.
     * @param color    - a Color.
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Point start, double width, double height, java.awt.Color color) {
        this.keyboard = keyboard;
        rect = new Rectangle(start, width, height);
        this.color = color;
        this.speed = 6;
    }

    /**
     * This method gets a leftBoarder and rightBoarder variables as the borders the paddle
     * cant cross.
     *
     * @param leftBoarder  - a double.
     * @param rightBoarder - a double.
     */
    public void setBoarders(double leftBoarder, double rightBoarder) {
        this.leftBoarder = leftBoarder;
        this.rightBoarder = rightBoarder;
    }

    /**
     * This method is used to update the location of the paddle after the user press the left arrow key.
     */
    public void moveLeft() {
        final double maxSize = 0, minSize = 5;
        Point start = this.rect.getUpperLeft();
        double width = this.rect.getWidth(), height = this.rect.getHeight();
        if (start.getX() >= leftBoarder + maxSize) {
            this.rect = new Rectangle(new Point(start.getX() - this.speed, start.getY()), width, height);
        }
    }

    /**
     * This method is used to update the location of the paddle after the user press the right arrow key.
     */
    public void moveRight() {
        final double maxSize = 0;
        Point start = this.rect.getUpperLeft();
        double width = this.rect.getWidth(), height = this.rect.getHeight();
        if (start.getX() + width <= rightBoarder - maxSize) {
            this.rect = new Rectangle(new Point(start.getX() + this.speed, start.getY()), width, height);
        }
    }

    /**
     * This method exist because Paddle implements Sprite, the Method used to change the Paddle after the "time passed".
     * simply calls the moveLeft method if the user pressed the left arrow key and calls the moveRight method
     * is the user pressed the right arrow key.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * This method is used to draw the paddle in the given Drawsurface surface.
     * The method isn't return any value.
     *
     * @param d - the Drawsurface variable.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }


    /**
     * This method exists because Block implements Collidable, the Method used to return this instance
     * of Sprites.Block rectangle.
     *
     * @return BasicShapes.Rectangle variable.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * this method exists because Paddle implements Collidable class. the method gets a collision point and a velocity
     * and returns an updated velocity of the hitted item by the location of the hit.
     *
     * @param collisionPoint  - a given Point.
     * @param currentVelocity - a given Velocity.
     * @param hitter          - a given Ball.
     * @return Logics.Velocity variable
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point start = rect.getUpperLeft();
        double ballsSpeed = Math.sqrt(Math.pow(hitter.getVelocity().getDx(), 2)
                + Math.pow(hitter.getVelocity().getDy(), 2));
        double startX = start.getX(), startY = start.getY();
        double width = this.rect.getWidth();
        Line area1 = new Line(start, new Point(startX + (width / 5), startY));
        Line area2 = new Line(area1.end(), new Point(area1.end().getX() + (width / 5), startY));
        Line area3 = new Line(area2.end(), new Point(area2.end().getX() + (width / 5), startY));
        Line area4 = new Line(area3.end(), new Point(area3.end().getX() + (width / 5), startY));
        Line area5 = new Line(area4.end(), new Point(area4.end().getX() + (width / 5), startY));
        final double trashhold = 10 ^ -10;
        Line tempL = new Line(collisionPoint.getX() + trashhold, collisionPoint.getY() + trashhold,
                collisionPoint.getX() - trashhold, collisionPoint.getY() - trashhold);
        Velocity newV;
        if (this.sideOfCrash == 3 || this.sideOfCrash == 4) {
            newV = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        } else if (this.sideOfCrash == 1 && currentVelocity.getDy() < 0) {
            if (currentVelocity.getDx() > 0) {
                newV = new Velocity(3, -currentVelocity.getDy());
            } else {
                newV = new Velocity(-3, -currentVelocity.getDy());
            }

        } else if (area1.isIntersecting(tempL)) {
            newV = Velocity.fromAngleAndSpeed(300, ballsSpeed);
        } else if (area2.isIntersecting(tempL)) {
            newV = Velocity.fromAngleAndSpeed(330, ballsSpeed);
        } else if (area4.isIntersecting(tempL)) {
            newV = Velocity.fromAngleAndSpeed(30, ballsSpeed);
        } else if (area5.isIntersecting(tempL)) {
            newV = Velocity.fromAngleAndSpeed(60, ballsSpeed);
        } else {
            newV = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        return newV;
    }

    /**
     * This method exist because Sprites.Paddle implements Sprite, the Method used to add the paddle to Sprites List
     * in the given GameTools.Game.
     *
     * @param g - a given GameTools.Game parameter.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    @Override
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * This method used to set this Blocks side of collision with a ball.
     * this method isn't return any value
     *
     * @param num - the given number
     */
    @Override
    public void sideOfCol(int num) {
        this.sideOfCrash = num;
    }

    /**
     * This method role is to Set the ball variable of thr current Paddle.
     *
     * @param b - a given Ball.
     */
    public void setBall(Ball b) {
        this.ball = b;
    }

    /**
     * This method role is to Set the current ball's speed of thr current Paddle.
     *
     * @param speed - a given double.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
