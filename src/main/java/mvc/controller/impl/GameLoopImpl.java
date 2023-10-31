package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameLoop;
import mvc.model.Sliceable;
import mvc.view.impl.GameScreen;
import mvc.view.impl.GameArea;
import mvc.view.impl.ScoreViewImpl;

import javax.swing.Timer;
import java.util.Random;

/**
 * Implementation class of GameLoop interface.
 * Check the relative interface for the documentation.
 */
public class GameLoopImpl implements GameLoop {
    private static final Integer DELAY = 1500;
    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;
    private static final Random RANDOM = new Random();
    private static final Double PERCENTAGE = 0.3;
    private final GameScreen screen;

    /**
     * Constructor.
     * @param world game world controller.
     * @param screen the GameScreen.
     */
    @SuppressFBWarnings
    public GameLoopImpl(final GameWorldControllerImpl world, final GameScreen screen) {
        this.world = world;
        this.screen = screen;
        this.physics = new PhysicControllerImpl(0.5, world);
        final GameArea area = screen.createAndShowGui();
        setupGameLoop(area);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void loop(final GameArea area) {
        final double choice = RANDOM.nextDouble(1);

        if (choice < PERCENTAGE) {
            final Sliceable bomb = world.createBomb(0);
            area.addBomb(bomb.getPosition(), 0);
        } else {
            final int id = RANDOM.nextInt(100);
            final Sliceable slice = world.createPolygon(id);
            area.addPolygon(slice.getPosition(), slice.getSides(), id);
        }
    }

    /**
     * {@inheritDoc}.
     * @param area GameArea to be painted.
     */
    private void setupGameLoop(final GameArea area) {
        final Timer gameTimer = new Timer(DELAY, e -> loop(area));
        final Timer redrawTimer = new Timer(30, e -> startRedrawTimer(area));
        redrawTimer.setRepeats(true);
        redrawTimer.start();
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    /**
     * Creates a timer for the rendering of the sliceables.
     * @param area the game area where the polygons are displayed.
     */
    private void startRedrawTimer(final GameArea area) {
        physics.updateSliceablesPosition();
        /* Updates the new position of the polygons model congruently to their view. */
        for (final var polyModel : world.getPolygons()) {
            for (final var polyView : area.getPolygons()) {
                if (polyModel.getSliceableId() == polyView.getPolygonId()) {
                    polyView.setPosition(polyModel.getPosition());
                    if (polyModel.getPosition().getY() >= 1000) {
                        area.deletePolygon(polyView);
                        world.deletePolygon(polyModel);
                    }
                }
            }
        }
        /* Now for the bombs. */
        for (final var bombModel : world.getBombs()) {
            for (final var bombView : area.getBombs()) {
                if (bombModel.getSliceableId() == bombView.getPolygonId()) {
                    bombView.setPosition(bombModel.getPosition());
                    if (bombModel.getPosition().getY() >= 1000) {
                        area.deleteBomb(bombView);
                        world.deleteBomb(bombModel);
                    }
                }
            }
        }
        area.repaint();
    }
}

