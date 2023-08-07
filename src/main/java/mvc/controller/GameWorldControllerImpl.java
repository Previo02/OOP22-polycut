package mvc.controller;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * 
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
        factory.createPolygon();
    }

}
