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

public class WideEasyLevel implements LevelInformation {
    private int ballsNum = 10;
    private int paddleSpeed = 3, paddleWidth = 510;

    @Override
    public int numberOfBalls() {
        return this.ballsNum;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initBallVelo = new ArrayList<>();
        for (int i = 0; i < ballsNum; i++) {
            initBallVelo.add(new Velocity(i - (int) (ballsNum / 2), -5));
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
        return "Wide Easy";
    }


    @Override
    public Sprite getBackground() {
        List<Sprite> backgroundSprites = new ArrayList<>();
        Point p = new Point(160, 145);
        double x = 700;
        while (x >= 30) {
            OnScreenLine l = new OnScreenLine(new Line(p, new Point(x, 285)), Color.decode("#FFFACD"));
            backgroundSprites.add(l);
            if (x < 100) {
                x = x - 10;
            } else if (x < 200) {
                x = x - 12;
            } else if (x < 260) {
                x = x - 14;
            } else if (x < 360) {
                x = x - 12;
            } else if (x < 400) {
                x = x - 10;
            } else if (x < 460) {
                x = x - 8;
            } else if (x < 520) {
                x = x - 4;
            } else {
                x = x - 1;
            }
        }
        Circle c1 = new Circle(p, 80, Color.decode("#FFFACD"));
        c1.fillTheCircle(Color.decode("#FFFACD"));
        Circle c2 = new Circle(p, 68, Color.decode("#ffff80"));
        c2.fillTheCircle(Color.decode("#ffff80"));
        Circle c3 = new Circle(p, 50, Color.decode("#f9f906"));
        c3.fillTheCircle(Color.decode("#f9f906"));
        backgroundSprites.add(c1);
        backgroundSprites.add(c2);
        backgroundSprites.add(c3);
        Backgroud backgroud = new Backgroud(Color.white, backgroundSprites);
        return backgroud;
    }


    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colorsInd = new Color[15];
        for (int i = 0; i < 15; ++i) {
            if (i < 2) {
                colorsInd[i] = Color.red;
            } else if (i < 4) {
                colorsInd[i] = Color.orange;
            } else if (i < 6) {
                colorsInd[i] = Color.yellow;
            } else if (i < 9) {
                colorsInd[i] = Color.green;
            } else if (i < 11) {
                colorsInd[i] = Color.blue;
            } else if (i < 13) {
                colorsInd[i] = Color.pink;
            } else {
                colorsInd[i] = Color.cyan;
            }

        }
        for (int i = 0; i < 15; ++i) {
            blocks.add(new Block(new Rectangle(new Point(29 + 50 * i, 285), 50, 30), colorsInd[i]));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

}