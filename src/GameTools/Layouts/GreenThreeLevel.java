// Name: Aviad Ravid
// ID: 209321108
package GameTools.Layouts;

import BasicShapes.Line;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import GameTools.LevelInformation;
import Logics.Velocity;
import Sprites.Backgroud;
import Sprites.Ball;
import Sprites.Block;
import Sprites.Circle;
import Sprites.OnScreenLine;
import Sprites.OnScreenRecktangle;
import Sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GreenThreeLevel implements LevelInformation {
    private int ballsNum = 2;
    private int paddleSpeed = 6, paddleWidth = 100;
    private List<Ball> balls;

    @Override
    public int numberOfBalls() {
        return this.ballsNum;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initBallVelo = new ArrayList<>();
        initBallVelo.add(new Velocity(-3, -5));
        initBallVelo.add(new Velocity(3, -5));
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
        return "Green three";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> backgroundSprites = new ArrayList<>();
        Point p = new Point(120, 205);
        backgroundSprites.add(new OnScreenRecktangle(new Rectangle(new Point(80, 450), 80, 160),
                Color.darkGray.darker()));
        backgroundSprites.add(new OnScreenRecktangle(new Rectangle(new Point(100, 385), 40, 65),
                Color.darkGray));
        backgroundSprites.add(new OnScreenRecktangle(new Rectangle(new Point(114, 205), 12, 180),
                Color.darkGray.brighter()));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; ++j) {
                OnScreenRecktangle rec = new OnScreenRecktangle(new Rectangle(new Point(86 + 15 * j, 462 + 30 * i),
                        9, 24), Color.white);
                backgroundSprites.add(rec);
            }
        }
        double y = 170;
        while (y < 230) {
            OnScreenLine l = new OnScreenLine(new Line(120, 205, 30, y), Color.decode("#FFE24D"));
            backgroundSprites.add(l);
            y += 0.005;
        }
        Circle c1 = new Circle(p, 14, Color.decode("#FFB13C"));
        c1.fillTheCircle(Color.decode("#FFB13C"));
        Circle c2 = new Circle(p, 10, Color.decode("#FF4500"));
        c2.fillTheCircle(Color.decode("#FF4500"));
        Circle c3 = new Circle(p, 4, Color.WHITE);
        c3.fillTheCircle(Color.WHITE);
        backgroundSprites.add(c1);
        backgroundSprites.add(c2);
        backgroundSprites.add(c3);
        Backgroud backgroud = new Backgroud(Color.decode("#2e5422"), backgroundSprites);
        return backgroud;
    }

    @Override
    public List<Block> blocks() {
        final int blocksSize = 40, blockHeight = 28, blockWidth = 45;
        Block b = new Block(new Rectangle(new Point(385, 165), 30, 30), Color.RED);
        List<Block> blocksFinal = new ArrayList<>();
        Block[] blocks = new Block[blocksSize];
        int cnt = 0;
        java.awt.Color[] colors = {Color.gray, Color.RED, Color.cyan, Color.orange, Color.MAGENTA, Color.GREEN};
        for (int i = 0; i < 5; ++i) {
            for (int j = i; j < 10; ++j) {
                blocks[cnt] = new Block(new Rectangle(new Point(322 + (blockWidth * j), 170 + (blockHeight * i)),
                        blockWidth, blockHeight), colors[i]);
                cnt++;
            }
        }
        for (Block block : blocks) {
            blocksFinal.add(block);
        }
        return blocksFinal;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
