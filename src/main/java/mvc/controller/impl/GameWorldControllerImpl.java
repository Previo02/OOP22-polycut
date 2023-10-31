package mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;

import mvc.view.impl.GameScreen;
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
    private List<Sliceable> polygons;
    private List<Sliceable> bombs;

    /**
     * Constructor of the game world.
     */
    public GameWorldControllerImpl() {
        this.factory = new SliceableFactoryImpl();
        this.polygons = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sliceable> getPolygons() {
        return new ArrayList<>(this.polygons);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPolygons(final List<Sliceable> updatedList) {
        this.polygons = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sliceable> getBombs() {
        return new ArrayList<>(this.bombs); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBombs(final List<Sliceable> updatedList) {
        this.bombs = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sliceable createPolygon(final int sliceableId) {
        final Sliceable polygon = factory.createPolygon(sliceableId);
        this.polygons.add(polygon);
        return polygon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sliceable createBomb(final int bombId) {
        final Sliceable bomb = factory.createBomb(bombId);
        bombs.add(bomb);
        return bomb;
    }

    /**
     * TODO.
     * @param polyDelete .
     */
    public void deletePolygon(final Sliceable polyDelete) {
        this.polygons.remove(polyDelete);
    }

    /**
     * TODO.
     * @param bombDelete .
     */
    public void deleteBomb(final Sliceable bombDelete) {
        this.bombs.remove(bombDelete);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startLoop() {
        final GameScreen screen = new GameScreen();
        new GameLoopImpl(this, screen);
    }
}
