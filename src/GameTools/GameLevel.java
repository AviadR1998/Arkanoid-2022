// Name: Aviad Ravid
// ID: 209321108
package GameTools;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import CollisionTypes.Collidable;
import GameTools.AnimationTools.Animation;
import GameTools.AnimationTools.AnimationRunner;
import GameTools.AnimationTools.CountdownAnimation;
import GameTools.AnimationTools.PauseScreen;
import ListenerPattern.BlockRemover;
import ListenerPattern.HitListener;
import ListenerPattern.ScoreTrackingListener;
import Logics.Counter;
import Logics.Velocity;
import Sprites.OnScreenText;
import Sprites.Paddle;
import Sprites.Sprite;
import Sprites.SpriteCollection;
import Sprites.Block;
import Sprites.Ball;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ListenerPattern.BallRemover;
import Sprites.ScoreIndicator;

/**
 * The GameTools.Game class implements a GameTools.Game structure. every game structure made of SpriteCollection,
 * GUI and a GameTools.GameEnvironment.
 *
 * @author Aviad Ravid
 */
public class GameLevel implements HitListener, Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private AnimationRunner aniR;
    private Counter remainedBlocks;
    private Counter remainedBalls;
    private Counter score;
    private KeyboardSensor ks;
    private LevelInformation levelInf;

    /**
     * This method is used as a constructor to initialize a GameLevel's instance values.
     *
     * @param levelInf - a given LevelInformation.
     */
    public GameLevel(LevelInformation levelInf) {
        this.levelInf = levelInf;
    }

    /**
     * This method is used as a constructor to initialize a GameLevel's instance values.
     *
     * @param levelInf - a given LevelInformation.
     * @param ks       - a given KeyboardSensor.
     * @param ar       a given AnimationRunner.
     * @param score    - a given Counter parameter.
     */
    public GameLevel(LevelInformation levelInf, KeyboardSensor ks, AnimationRunner ar, Counter score) {
        this.levelInf = levelInf;
        this.ks = ks;
        this.aniR = ar;
        this.score = score;
    }

    /**
     * That method is used to add a collidable item to the GameTools.Game environment of that game instance.
     *
     * @param col - a given Collidable.
     */
    public void addCollidable(Collidable col) {
        this.environment.addCollidable(col);
    }

    /**
     * That method is used to add a Sprite item to the Game's SpriteCollection instance of that game instance.
     *
     * @param s - a given Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: creates the Blocks and all the Sprites, balls and padlle
     * by a given LevelInformation parameter, and add them to the game.
     */
    public void initialize() {
        final int height = 28, screenW = 800, screenH = 600, scoreLine = 20;
        List<Block> blocks = this.levelInf.blocks();
        List<Block> boarders = new ArrayList<Block>();
        boarders.add(new Block(new Rectangle(new Point(0, scoreLine), screenW, height), Color.darkGray));
        boarders.add(new Block(new Rectangle(new Point(0, height + scoreLine),
                height, screenH - height), Color.darkGray));
        boarders.add(new Block(new Rectangle(new Point(screenW - height, height + scoreLine),
                height, screenH - height), Color.darkGray));
        boarders.add(new Block(new Rectangle(new Point(0, screenH), screenW, 0), Color.white));
        for (Block bl : boarders) {
            blocks.add(bl);
        }
        this.remainedBlocks = new Counter(this.levelInf.numberOfBlocksToRemove());
        BlockRemover br = new BlockRemover(this, remainedBlocks);
        this.sprites = new SpriteCollection();
        this.levelInf.getBackground().addToGame(this);
        this.environment = new GameEnvironment();
        Paddle paddle = new Paddle(ks, new Point((int) (400 - this.levelInf.paddleWidth() / 2),
                530), this.levelInf.paddleWidth(), 12, Color.ORANGE);
        paddle.setSpeed(this.levelInf.paddleSpeed());
        paddle.setBoarders(30, 770);
        paddle.addToGame(this);
        this.remainedBalls = new Counter(0);
        ScoreIndicator scoreIn = new ScoreIndicator(new Rectangle(new Point(0, 0), screenW, scoreLine), this.score);
        scoreIn.addToGame(this);
        int textX = (int) (scoreIn.getRect().getRightL().start().getX() - (scoreIn.getRect().getWidth() / 4) - 30);
        int textY = (int) (scoreIn.getRect().getUpperLeft().getY() + 14);
        OnScreenText levelName = new OnScreenText("Level Name: " + this.levelInf.levelName(), textX, textY);
        levelName.addToGame(this);
        List<Velocity> velocities = levelInf.initialBallVelocities();
        for (int i = 0; i < levelInf.numberOfBalls(); i++) {
            Ball b = new Ball(new Point(400, 500), 5, Color.white);
            b.setVelocity(velocities.get(i));
            b.addToGame(this);
            b.setGe(environment);
            b.setPaddle(paddle);
            remainedBalls.increase(1);
        }
        BallRemover ballR = new BallRemover(this, remainedBalls);
        blocks.get(blocks.size() - 1).addHitListener(ballR);
        int max = blocks.size();
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        for (int i = 0; i < max; ++i) {
            blocks.get(i).addToGame(this);
            if (i < max - 4) {
                blocks.get(i).addHitListener(br);
                blocks.get(i).addHitListener(scoreTrack);
            }
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.aniR.run(new CountdownAnimation(1, 3, this.sprites));
        this.aniR.run(this);
    }

    /**
     * This method gets a block and a ball and calls the blocks removeFromGame method
     * to remove the given block from the current game instance.
     *
     * @param beingHit - a given block instace
     * @param hitter   - a given ball instance
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this);
    }

    /**
     * This method removes a given Sprite from this instance of game.
     *
     * @param s - a given sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * This method removes a given Collidable from this instance of game.
     *
     * @param c - a given sprite.
     */
    public void removeCollidable(Collidable c) {
        this.sprites.removeCollidable(c);
        this.environment.removeCollidable(c);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.ks.isPressed("p")) {
            this.aniR.run(new PauseScreen(this.ks));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (remainedBlocks.getValue() == 0) {
            this.score.increase(100);
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
        }
    }

    @Override
    public boolean shouldStop() {
        return this.remainedBlocks.getValue() == 0 || this.remainedBalls.getValue() <= 0;
    }

    /**
     * This method returns the number of balls that are still in the game.
     *
     * @return - an int.
     */
    public int getReaminingBalls() {
        return this.remainedBalls.getValue();
    }
}