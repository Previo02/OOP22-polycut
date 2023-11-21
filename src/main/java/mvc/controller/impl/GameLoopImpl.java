package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.App;
import mvc.controller.GameLoop;
import mvc.model.SliceableModel;
import mvc.model.impl.PolygonImpl;
import mvc.view.impl.GameScreenImpl;
import mvc.view.impl.LiveImpl;
import mvc.view.GameArea;

import javax.swing.Timer;
import java.util.Random;


/**
 *Implementation class of GameLoop interface.
 *Check the relative interface for the documentation.
 */
public class GameLoopImpl implements GameLoop {
    private static final Integer FIRST_LEVEL = 10;
    private static final Integer SECOND_LEVEL = 20;
    private static final Integer THIRD_LEVEL = 30;
    private static final Integer TWO_S = 2000;
    private static final Integer ONE_HALF_S = 1500;
    private static final Integer ONE_S = 1000;
    private static final Integer HALF_S = 500;
    private static final Double DT = 0.2;
    private Integer spawnTime;
    private static final Integer REDRAW_DELAY = 10;
    private static final double PERCENTAGE = 0.35;
    private static final Random RANDOM = new Random();

    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;
    private final GameScreenImpl screen;
    private final LiveImpl lives;
    private Timer gameTimer;
    private final Timer redrawTimer;

    /**
     * Constructor.
     * @param world game world controller.
     * @param screen the GameScreen.
     */
    @SuppressFBWarnings
    public GameLoopImpl(final GameWorldControllerImpl world, final GameScreenImpl screen) {
        this.lives = screen.getCurrentLives();
        this.screen = screen;
        this.world = world;
        this.spawnTime = TWO_S;
        this.physics = new PhysicControllerImpl(DT, world);
        final GameArea area = screen.createAndShowGui();

        if (area != null) {
            /*settings up the 2 timers, 1 for the object spawn and the other for the redrawing process*/
            this.gameTimer = new Timer(spawnTime, e -> this.loop(area));
            this.redrawTimer = new Timer(REDRAW_DELAY, e -> this.redraw(area));
            redrawTimer.setRepeats(true);
            redrawTimer.start();
            gameTimer.setRepeats(true);
            gameTimer.start();
        } else {
            this.gameTimer = null;
            this.redrawTimer = null;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void loop(final GameArea area) {
        final double choice = RANDOM.nextDouble();
        this.setDifficulty(area);
        final int id = RANDOM.nextInt();
        final SliceableModel sliceable = choice < PERCENTAGE ? world.createBomb(id) : this.world.createPolygon(id);
        area.drawSliceable(sliceable.getSliceableId(), sliceable.getPosition(), sliceable.getSides());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void redraw(final GameArea area) {
        gameOver();
        area.getSliced().stream().forEach(i -> world.outOfBoundDelete(i));
        physics.updateSliceablesPosition();
        this.world.getSliceables().stream()
                                .filter(SliceableModel::isOutOfBound)
                                .findFirst()
                                .ifPresent(sliceable -> {
                                    area.clean(sliceable.getSliceableId());
                                    world.outOfBoundDelete(sliceable.getSliceableId());
                                    if (sliceable instanceof PolygonImpl) {
                                        this.lives.decreaseLives();
                                    }
                                });
        this.world.getSliceables()
                    .forEach(s -> area.updatePosition(s.getSliceableId(), s.getPosition(), s.getSides()));
    }

    /**
     * Control if the game is finished, and starts a new App.
     */
    private void gameOver() {
        if (this.lives.getLivesCounter() > 0) {
            return;
        }
        gameTimer.stop();
        redrawTimer.stop();
        screen.setNewBestScore(screen.getCurrentBestScore());
        screen.gameOverPanel();
        App.initializeGame();
    }

    /**
     * Set the difficulty.
     * @param area the game area
     */
    private void setDifficulty(final GameArea area) {
        final int score = screen.getScoreValue();
        boolean updateTimer = false;

        if (score == FIRST_LEVEL) {
            spawnTime = ONE_HALF_S;
            updateTimer = true;
        } else if (score == SECOND_LEVEL) {
            spawnTime = ONE_S;
            updateTimer = true;
        } else if (score == THIRD_LEVEL) {
            spawnTime = HALF_S;
            updateTimer = true;
        }

        if (updateTimer) {
            gameTimer.stop();
            gameTimer = new Timer(spawnTime, e -> this.loop(area));
            gameTimer.setRepeats(true);
            gameTimer.start();
        }
    }
}
