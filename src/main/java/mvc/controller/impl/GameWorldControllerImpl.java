package mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;

import mvc.controller.GameWorldController;
import mvc.model.SliceableModel;
import mvc.model.SliceableFactory;
import mvc.model.impl.SliceableFactoryImpl;
import mvc.view.impl.GameScreen;

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
        final GameScreen screen = new GameScreen();
        new GameLoopImpl(this, screen);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void outOfBoundDelete(final int sliceableId) {

        for (int i = 0; i < getPolygons().size(); i++) {
            final var poly = getPolygons().get(i);
            if (poly.getSliceableId() == sliceableId) {
                polygons.remove(i);
                break;
            }
        }

        for (int i = 0; i < getBombs().size(); i++) {
            final var bomb = getBombs().get(i);
            if (bomb.getSliceableId() == sliceableId) {
                bombs.remove(i);
                break;
            }
        }
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
        final List<SliceableModel> sliceableList = new ArrayList<>(getPolygons());
        sliceableList.addAll(getBombs());
        return sliceableList;
    }
}
