package mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mvc.view.impl.GameScreen;
import mvc.controller.GameLoop;
import mvc.controller.GameWorldController;
import mvc.model.Sliceable;
import mvc.model.SliceableFactory;
import mvc.model.impl.SliceableFactoryImpl;

/**
 * Implementation class of the GameWorld controller.
 * Check GameWorldController documentation.
 */
public class GameWorldControllerImpl implements GameWorldController {
    private final SliceableFactory factory;
    private List<Sliceable> sliceables;
    private static final double PERCENTAGE = 0.3;
    private static final Random RANDOM = new Random();

    /**
     * Constructor of the game world.
     */
    public GameWorldControllerImpl() {
        this.factory = new SliceableFactoryImpl();
        this.sliceables = new ArrayList<>();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Sliceable> getVisibleSliceables() {
        return new ArrayList<>(this.sliceables);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setVisibleSliceables(final List<Sliceable> updatedList) {
        this.sliceables = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createSliceables() {
        final double randVal = RANDOM.nextDouble(0, 1);
        if (randVal >= PERCENTAGE) {
            final Sliceable polygon = factory.createPolygon();
            sliceables.add(polygon);

        } else {
            final Sliceable bomb = factory.createBomb();
            sliceables.add(bomb);
        }
    }

    /**
     * Creating the GUI.
     */
    public void createAndShowGui() {
        final GameLoop gameLoop = new GameLoopImpl(this);
        final GameScreen screen = new GameScreen();
        gameLoop.loop(screen);
    }
}
