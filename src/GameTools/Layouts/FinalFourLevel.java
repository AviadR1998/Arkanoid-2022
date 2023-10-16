// Name: Aviad Ravid
// ID: 209321108
package GameTools.Layouts;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import GameTools.LevelInformation;
import Logics.Velocity;
import Sprites.Backgroud;
import Sprites.Block;
import Sprites.Circle;
import Sprites.OnScreenLine;
import Sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FinalFourLevel implements LevelInformation {
    private int ballsNum = 3;
    private int paddleSpeed = 7, paddleWidth = 100;

    @Override
    public int numberOfBalls() {
        return this.ballsNum;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initBallVelo = new ArrayList<>();
        for (int i = 0; i < ballsNum; i++) {
            initBallVelo.add(new Velocity(i - (int) (ballsNum / 2), 5));
        }
        return initBallVelo;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> backgroundSprites = new ArrayList<>();
        int y, x;
        for (int i = 0; i < 6; i++) {
            y = 512;
            x = 614 + i * 12;
            while (y <= 620) {
                OnScreenLine l = new OnScreenLine(new Line(x, y, x - 3, y + 8), Color.white);
                y += 13;
                x -= 4;
                backgroundSprites.add(l);
            }
        }
        Circle c1 = new Circle(new Point(606, 478), 23, Color.decode("#DCDCDC"));
        c1.fillTheCircle(Color.decode("#DCDCDC"));
        Circle c2 = new Circle(new Point(632, 512), 26, Color.decode("#DCDCDC"));
        c2.fillTheCircle(Color.decode("#DCDCDC"));
        Circle c3 = new Circle(new Point(645, 485), 30, Color.decode("#C0C0C0"));
        c3.fillTheCircle(Color.decode("#C0C0C0"));
        Circle c4 = new Circle(new Point(675, 490), 32, Color.decode("#A9A9A9"));
        c4.fillTheCircle(Color.decode("#A9A9A9"));
        Circle c5 = new Circle(new Point(658, 510), 24, Color.decode("#A9A9A9"));
        c5.fillTheCircle(Color.decode("#A9A9A9"));
        backgroundSprites.add(c1);
        backgroundSprites.add(c2);
        backgroundSprites.add(c3);
        backgroundSprites.add(c4);
        backgroundSprites.add(c5);
        for (int i = 0; i < 6; i++) {
            y = 462;
            x = 114 + i * 12;
            while (y <= 620) {
                OnScreenLine l = new OnScreenLine(new Line(x, y, x - 3, y + 8), Color.white);
                y += 13;
                x -= 4;
                backgroundSprites.add(l);
            }
        }
        Circle c21 = new Circle(new Point(106, 428), 23, Color.decode("#DCDCDC"));
        c21.fillTheCircle(Color.decode("#DCDCDC"));
        Circle c22 = new Circle(new Point(132, 462), 26, Color.decode("#DCDCDC"));
        c22.fillTheCircle(Color.decode("#DCDCDC"));
        Circle c23 = new Circle(new Point(145, 435), 30, Color.decode("#C0C0C0"));
        c23.fillTheCircle(Color.decode("#C0C0C0"));
        Circle c24 = new Circle(new Point(175, 440), 32, Color.decode("#A9A9A9"));
        c24.fillTheCircle(Color.decode("#A9A9A9"));
        Circle c25 = new Circle(new Point(158, 460), 24, Color.decode("#A9A9A9"));
        c25.fillTheCircle(Color.decode("#A9A9A9"));
        backgroundSprites.add(c21);
        backgroundSprites.add(c22);
        backgroundSprites.add(c23);
        backgroundSprites.add(c24);
        backgroundSprites.add(c25);
        Backgroud backgroud = new Backgroud(Color.decode("#1c80dd"), backgroundSprites);
        return backgroud;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colorsInd = {Color.gray, Color.red, Color.yellow, Color.green,
                Color.WHITE, Color.pink, Color.decode("#89cff0")};
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 15; ++j) {
                blocks.add(new Block(new Rectangle(new Point(29 + 50 * j, 110 + 25 * i), 50, 25), colorsInd[i]));
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }

}
