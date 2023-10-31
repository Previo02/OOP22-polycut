package mvc.controller.impl;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import mvc.view.SliceableView;
import mvc.view.impl.GameArea;
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
        polygons.add(polygon);
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
     * {@inheritDoc}
     */
    @Override
    public void startLoop() {
        final GameScreen screen = new GameScreen();
        GameArea testArea = screen.createAndShowGui();
        this.polygons.add(factory.createPolygon(0));
        Sliceable poliTest = this.polygons.get(0);
        testArea.drawSliceable( new Point2D.Double(150, 150), poliTest.getSides());
        //new GameLoopImpl(this, screen);
    }

    @Override
    public void outOfBoundDelete(final int sliceableId, final List<Sliceable> sliceablesModel, final List<SliceableView> sliceablesView) {
        final var viewIterator = sliceablesView.iterator();
        final var modelIterator = getSliceables().iterator();

        while (modelIterator.hasNext()) {
            final Sliceable sliceable = modelIterator.next();
            if (sliceable.getSliceableId() == sliceableId) {
                modelIterator.remove();
            }
        }

        while (viewIterator.hasNext()) {
            final SliceableView sliceable = viewIterator.next();
            if (sliceable.getSliceableId() == sliceableId) {
                viewIterator.remove();
            }
        }

    }

    public List<Sliceable> getSliceables() {
        List<Sliceable> sliceableList = new ArrayList<>(getPolygons());
        sliceableList.addAll(getBombs());
        return sliceableList;
    }

}
