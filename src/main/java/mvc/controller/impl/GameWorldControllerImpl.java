package mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mvc.controller.GameWorldController;
import mvc.model.SliceableModel;
import mvc.model.SliceableFactory;
import mvc.model.impl.SliceableFactoryImpl;
import mvc.view.impl.GameScreenImpl;

/**
 * Implementation class of the GameWorld controller.
 * Check GameWorldController documentation.
 */
public class GameWorldControllerImpl implements GameWorldController {

    private final SliceableFactory factory;
    private List<SliceableModel> polygons;
    private List<SliceableModel> bombs;

    /**
     * Constructor of the game world.
     */
    public GameWorldControllerImpl() {
        this.factory = new SliceableFactoryImpl();
        this.polygons = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<SliceableModel> getPolygons() {
        return new ArrayList<>(this.polygons);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setPolygons(final List<SliceableModel> updatedList) {
        this.polygons = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<SliceableModel> getBombs() {
        return new ArrayList<>(this.bombs);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setBombs(final List<SliceableModel> updatedList) {
        this.bombs = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public SliceableModel createPolygon(final int sliceableId) {
        final SliceableModel polygon = factory.createPolygon(sliceableId);
        this.polygons.add(polygon);
        return polygon;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public SliceableModel createBomb(final int bombId) {
        final SliceableModel bomb = factory.createBomb(bombId);
        this.bombs.add(bomb);
        return bomb;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void startLoop() {
        final GameScreenImpl screen = new GameScreenImpl();
        new GameLoopImpl(this, screen);
    }

    /**
     * Delete the sliceable object from the list by its ID.
     * @param <T> extends SliceableModel class
     * @param sliceables the list of sliceables
     * @param sliceableId the ID of the sliceable
     */
    private <T extends SliceableModel> void deleteSliceableById(final List<T> sliceables,
                                                                final Integer sliceableId) {
        sliceables.removeIf(sliceable -> sliceable.getSliceableId() == sliceableId);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void outOfBoundDelete(final int sliceableId) {
        deleteSliceableById(this.polygons, sliceableId);
        deleteSliceableById(this.bombs, sliceableId);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void addBomb(final SliceableModel bomb) {
        this.bombs.add(bomb);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void addPolygon(final SliceableModel polygon) {
        this.polygons.add(polygon);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<SliceableModel> getSliceables() {
        return Stream.concat(getPolygons().stream(), getBombs().stream())
                .collect(Collectors.toList());
    }
}
