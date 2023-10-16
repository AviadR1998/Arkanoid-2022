// Name: Aviad Ravid
// ID: 209321108
package Sprites;


import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Logics.Velocity;
import CollisionTypes.Collidable;
import CollisionTypes.CollisionInfo;
import GameTools.GameLevel;
import GameTools.GameEnvironment;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The Sprites.Ball class implements a Sprites.Ball structure with color, radius, point values, and velocity.
 *
 * @author Aviad Ravid
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private double maxX = 200;
    private double minX = 0;
    private double maxY = 200;
    private double minY = 0;
    private GameEnvironment ge;
    private Paddle paddle;

    /**
     * This method is used as a constructor to initialize a ball's instance values.
     *
     * @param center - a point.
     * @param r      - a radius parameter.
     * @param color  - a color parameter.
     *               The method isn't return any value.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(1, 1);
        this.paddle = null;
    }

    /**
     * This method is used as a constructor to initialize a ball's instance values.
     *
     * @param x     - a x value of a point.
     * @param y     - a y value of a point
     * @param r     - a radius parameter.
     * @param color - a color parameter.
     *              The method isn't return any value.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(1, 1);
        this.paddle = null;
    }

    /**
     * This method is used to set the maxX, maximum width the ball can reach, of this instance of a Sprites.Ball.
     *
     * @param maxX - a double parameter.
     *             The method isn't return any value.
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    /**
     * This method is used to set the maxX, maximum height the ball can reach, of this instance of a Sprites.Ball.
     *
     * @param maxY - a double parameter.
     *             The method isn't return any value.
     */
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    /**
     * This method is used to set the minX, minimum width the ball can reach, of this instance of a Sprites.Ball.
     *
     * @param minX - a double parameter.
     *             The method isn't return any value.
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }

    /**
     * This method is used to set the maxX, minimum height the ball can reach, of this instance of a Sprites.Ball.
     *
     * @param minY - a double parameter.
     *             The method isn't return any value.
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }

    /**
     * This method is used to set the velocity of this instance of a Sprites.Ball.
     *
     * @param v - a velocity parameter.
     *          The method isn't return any value.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * This method is used to set the velocity of this instance of a Sprites.Ball.
     *
     * @param dx .
     * @param dy .
     *           The method isn't return any value.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * This method is used to set the gameEnvironment of this instance of a Sprites.Ball.
     *
     * @param ge .
     *           The method isn't return any value.
     */
    public void setGe(GameEnvironment ge) {
        this.ge = ge;
    }

    /**
     * This method is used to set the Sprites.Paddle of this instance of a Sprites.Ball.
     *
     * @param paddle .
     *               The method isn't return any value.
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * This method is used to return the value of the x parameter of the center point of the Sprites.Ball.
     *
     * @return this method returns an int value.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * This method is used to return the value of the y parameter of the center point of the Sprites.Ball.
     *
     * @return this method returns an int value.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * This method is used to return the size of the Sprites.Ball.
     *
     * @return this method returns an int value.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * This method is used to return the color of the Sprites.Ball.
     *
     * @return this method returns a java.awt.Color value.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This method is used to return the velocity of the Sprites.Ball.
     *
     * @return this method returns the velocity value of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * This method is used to change the center of the ball. if the new center crosses the limit of
     * the surface, currently, 200, the ball's velocity will change direction.
     * The method isn't return any value.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, new Point(this.center.getX() + this.v.getDx(),
                this.center.getY() + this.v.getDy()));
        final double trashHold = 0.005, paddleMovement = 6;
        CollisionInfo colI = this.ge.getClosestCollision(trajectory);
        if (this.paddle != null) {
            if (this.center.getX() >= this.paddle.getCollisionRectangle().getLeftL().start().getX()
                    && this.center.getX() <= this.paddle.getCollisionRectangle().getRightL().start().getX()
                    && this.center.getY() >= this.paddle.getCollisionRectangle().getTopL().start().getY()
                    && this.center.getY() <= this.paddle.getCollisionRectangle().getButtomL().start().getY()) {
                Point tempL = this.paddle.getCollisionRectangle().getLeftL().start();
                Point tempR = this.paddle.getCollisionRectangle().getRightL().start();
                if (this.center.distance(tempL) > this.center.distance(tempR)) {
                    this.center = new Point(this.center.getX(), tempR.getY() - 1);
                } else {
                    this.center = new Point(this.paddle.getCollisionRectangle().getLeftL().start().getX()
                            - paddleMovement, tempL.getY() - 1);
                }
                //this.setVelocity(this.v.getDx(), -this.v.getDy());
                return;
            }
        }
        if (colI != null) {
            colI.collisionObject().getCollisionRectangle().setBallsLine(trajectory);
            if (this.v.getDy() < 0) {
                if (this.v.getDx() < 0) {
                    this.center = new Point(colI.collisionPoint().getX() + trashHold,
                            colI.collisionPoint().getY() + trashHold);
                } else {
                    this.center = new Point(colI.collisionPoint().getX() - trashHold,
                            colI.collisionPoint().getY() + trashHold);
                }
            } else {
                if (this.v.getDx() > 0) {
                    this.center = new Point(colI.collisionPoint().getX() - trashHold,
                            colI.collisionPoint().getY() - trashHold);
                } else {
                    this.center = new Point(colI.collisionPoint().getX() + trashHold,
                            colI.collisionPoint().getY() - trashHold);
                }
            }
            Collidable col = colI.collisionObject();
            Rectangle rec = col.getCollisionRectangle();
            col.sideOfCol(this.sideOFCollision(trajectory, rec.getRightL(), rec.getLeftL(), rec.getTopL(),
                    rec.getButtomL()));
            this.setVelocity(colI.collisionObject().hit(this, colI.collisionPoint(), this.v));
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * This method is used to draw the ball in the given Drawsurface surface.
     * The method isn't return any value.
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.r);
        if (this.color.equals(Color.white) || this.color.equals(color.WHITE)) {
            surface.setColor(Color.black);
        }
        surface.drawCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * This method exist because Ball implements Sprite, the Method used to change the ball after the "time passed".
     * simply calls moveOneStep method.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * This method exist because Sprites.Ball implements Sprites.Sprite, the Method used to add the ball to Sprites List
     * in the given GameTools.Game.
     *
     * @param g - a given GameTools.Game parameter.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * This method gets 4 lines represent 4 sides of a collidable instance and returns the side of collision between the
     * ball and a collidable instance. 1 for top, 2 for the bottom, 3 for the left, and 4 for the right.
     *
     * @param ballsLine - line that represents the movement of the ball.
     * @param rightL    - BasicShapes.Line that represnts the right side of the collidable
     * @param leftL     - BasicShapes.Line that represnts the left side of the collidable
     * @param topL      - BasicShapes.Line that represnts the top side of the collidable
     * @param bottomL   - BasicShapes.Line that represnts the bottom side of the collidable
     * @return this method returns an int.
     */
    public int sideOFCollision(Line ballsLine, Line rightL, Line leftL, Line topL, Line bottomL) {
        if (topL.isIntersecting(ballsLine)) {
            if (leftL.isIntersecting(ballsLine)) {
                if (this.getVelocity().getDx() >= 0) {
                    return 1;
                }
                return 3;
            }
            if (rightL.isIntersecting(ballsLine)) {
                if (this.getVelocity().getDx() >= 0) {
                    return 1;
                }
                return 4;
            }
            return 1;
        }
        if (bottomL.isIntersecting(ballsLine)) {
            if (leftL.isIntersecting(ballsLine)) {
                if (this.getVelocity().getDy() <= 0) {
                    return 2;
                }
                return 3;
            }
            if (rightL.isIntersecting(ballsLine)) {
                if (this.getVelocity().getDy() <= 0) {
                    return 2;
                }
                return 4;
            }
            return 2;
        }
        if (leftL.isIntersecting(ballsLine)) {
            return 3;
        }
        if (rightL.isIntersecting(ballsLine)) {
            return 4;
        }
        return -1;
    }

    /**
     * This method removes this instance of ball from a given game.
     *
     * @param game - a given Game variable.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
