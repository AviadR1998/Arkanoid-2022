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

public class DirectHitLevel implements LevelInformation {
    private int ballsNum = 1;
    private int paddleSpeed = 5, paddleWidth = 75;

    @Override
    public int numberOfBalls() {
        return this.ballsNum;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initBallVelo = new ArrayList<>();
        for (int i = 0; i < ballsNum; i++) {
            initBallVelo.add(new Velocity(0, 6));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        List<Sprite> backgroundSprites = new ArrayList<>();
        Point p = new Point(400, 180);
        Color blue = Color.BLUE;
        for (int i = 0; i < 3; ++i) {
            backgroundSprites.add(new Circle(p, 40 + 25 * i, blue));
        }
        OnScreenLine osl1, osl2, osl3, osl4;
        osl1 = new OnScreenLine(new Line(375, 180, 285, 180), blue);
        osl2 = new OnScreenLine(new Line(425, 180, 515, 180), blue);
        osl3 = new OnScreenLine(new Line(400, 155, 400, 65), blue);
        osl4 = new OnScreenLine(new Line(400, 205, 400, 295), blue);
        backgroundSprites.add(osl1);
        backgroundSprites.add(osl2);
        backgroundSprites.add(osl3);
        backgroundSprites.add(osl4);
        Backgroud backgroud = new Backgroud(Color.black, backgroundSprites);
        return backgroud;
    }


    @Override
    public List<Block> blocks() {
        Block b = new Block(new Rectangle(new Point(385, 165), 30, 30), Color.RED);
        List<Block> blocks = new ArrayList<>();
        blocks.add(b);
        return blocks;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
