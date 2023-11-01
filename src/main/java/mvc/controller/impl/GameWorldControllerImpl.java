package mvc.controller.impl;

import java.util.ArrayList;
import java.util.List;

import mvc.controller.GameWorldController;
import mvc.model.SliceableModel;
import mvc.model.SliceableFactory;
import mvc.model.impl.SliceableFactoryImpl;

/**
 * Implementation class of the GameWorld controller.
 * Check GameWorldController documentation.
 */
public class GameWorldControllerImpl implements GameWorldController {

    private final SliceableFactory factory;
    private List<SliceableModel> polygons;
    private List<SliceableModel> bombs;
    // private final PhysicController physicController;
    // private static final Double DT = 1.0;

    /**
     * Constructor of the game world.
     */
    public GameWorldControllerImpl() {
        this.factory = new SliceableFactoryImpl();
        this.polygons = new ArrayList<>();
        this.bombs = new ArrayList<>();
        // this.physicController = new PhysicControllerImpl(0.1, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SliceableModel> getPolygons() {
        return new ArrayList<>(this.polygons);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPolygons(final List<SliceableModel> updatedList) {
        this.polygons = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SliceableModel> getBombs() {
        return new ArrayList<>(this.bombs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBombs(final List<SliceableModel> updatedList) {
        this.bombs = new ArrayList<>(updatedList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SliceableModel createPolygon(final int sliceableId) {
        final SliceableModel polygon = factory.createPolygon(sliceableId);
        this.polygons.add(polygon);
        return polygon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SliceableModel createBomb(final int bombId) {
        final SliceableModel bomb = factory.createBomb(bombId);
        this.bombs.add(bomb);
        return bomb;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startLoop() {
        // final int coordinates = 0;
        // final GameScreen screen = new GameScreen();
        // final GameArea testArea = screen.createAndShowGui();
        // this.polygons.add(factory.createPolygon(0));
        // final SliceableModel poliTest1 = this.polygons.get(0);
        // final var label1 = testArea.drawSliceable(new Point2D.Double(coordinates, coordinates), poliTest1.getSides());

        // for (int i = 0; i < 10; i++) {
        //     physicController.updateSliceablesPosition();
        //     testArea.updatePosition(label1, this.polygons.get(0).getPosition(), this.polygons.get(0).getSides());
        //     System.out.println(this.polygons.get(0).getPosition());
        // }

        // final GameScreen screen = new GameScreen();
        // new GameLoopImpl(this, screen);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void outOfBoundDelete(final int sliceableId) {
        final var polyIterator = this.polygons.iterator();
        while (polyIterator.hasNext()) {
            final var poly = polyIterator.next();
            if (poly.getSliceableId() == sliceableId) {
                polyIterator.remove();
            }
        }
        final var bombIterator = this.bombs.iterator();
        while (bombIterator.hasNext()) {
            final var bomb = bombIterator.next();
            if (bomb.getSliceableId() == sliceableId) {
                bombIterator.remove();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBomb(final SliceableModel bomb) {
        this.bombs.add(bomb);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPolygon(final SliceableModel polygon) {
        this.polygons.add(polygon);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SliceableModel> getSliceables() {
        final List<SliceableModel> sliceableList = new ArrayList<>(getPolygons());
        sliceableList.addAll(getBombs());
        return sliceableList;
    }

}
