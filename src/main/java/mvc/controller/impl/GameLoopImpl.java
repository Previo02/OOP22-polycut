package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameLoop;
import mvc.model.SliceableModel;
import mvc.view.impl.GameScreen;
import mvc.view.GameArea;

import javax.swing.Timer;
import java.util.Random;

/**
 *Implementation class of GameLoop interface.
 *Check the relative interface for the documentation.
 */
public class GameLoopImpl implements GameLoop {

    private static final Double DT = 0.5;
    private static final Integer DELAY = 3000;
    private static final Integer REDRAW_DELAY = 30;
    private static final double PERCENTAGE = 0.35;
    private static final Random RANDOM = new Random();

    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;

    /**
     * Constructor.
     * @param world game world controller.
     * @param screen the GameScreen.
     */
    @SuppressFBWarnings
    public GameLoopImpl(final GameWorldControllerImpl world, final GameScreen screen) {
        this.world = world;
        this.physics = new PhysicControllerImpl(DT, world);
        final GameArea area = screen.createAndShowGui();

        /*settings up the 2 timers, 1 for the object spawn and the other for the redrawing process*/
        final Timer gameTimer = new Timer(DELAY, e -> this.loop(area));
        final Timer redrawTimer = new Timer(REDRAW_DELAY, e -> this.redraw(area));
        redrawTimer.setRepeats(true);
        redrawTimer.start();
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void loop(final GameArea area) {
        final double choice = RANDOM.nextDouble();

        if (choice < PERCENTAGE) {
            int id;
            SliceableModel bomb;
            id = RANDOM.nextInt();
            bomb = this.world.createBomb(id);
            area.drawSliceable(bomb.getSliceableId(), bomb.getPosition(), bomb.getSides());
            // System.out.println("Bomba creata");
        } else {
            int id;
            SliceableModel polygon;
            id = RANDOM.nextInt();
            polygon = this.world.createPolygon(id);
            area.drawSliceable(polygon.getSliceableId(), polygon.getPosition(), polygon.getSides());
            // System.out.println("Poligono creato");
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void redraw(final GameArea area) {
        physics.updateSliceablesPosition();
        for (final var sliceable : this.world.getSliceables()) {
            if (sliceable.isOutOfBound()) {
                area.clean(sliceable.getSliceableId());
                world.outOfBoundDelete(sliceable.getSliceableId());
            }
            area.updatePosition(sliceable.getPosition(), sliceable.getSides());
        }
    }
}
