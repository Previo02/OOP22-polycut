package mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mvc.model.Sliceable;
import mvc.model.SliceableFactory;
import mvc.model.impl.SliceableFactoryImpl;

/**
 * Implementation class of the GameWordl controller.
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
     * {@inheritdoc}.
     */
    @Override
    public List<Sliceable> getVisibleSliceables() {
        return this.sliceables;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public void setVisibleSliceables(final List<Sliceable> updatedList) {
        this.sliceables = updatedList;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public void createSliceables() {
        final Random rand = new Random();

        for (int i = 0; i < rand.nextInt(10); i++) {
            this.sliceables.add(this.factory.createPolygon());
        }

    }

}
