package mvc.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mvc.model.Blade;
import mvc.model.SliceableModel;

/**
 * Implementation of the user input.
 */
public class BladeImpl implements Blade {
    private final List<SliceableModel> activeSliceables;

    /**
     * Initialize the list of actives sliceable objects.
     */
    public BladeImpl() {
        this.activeSliceables = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSliceable(final SliceableModel object) {
        this.activeSliceables.add(Objects.requireNonNull(object));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteSliceable(final SliceableModel object) {
        this.activeSliceables.remove(Objects.requireNonNull(object));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SliceableModel> getActiveSliceables() {
        return new ArrayList<>(this.activeSliceables);
    }
}
