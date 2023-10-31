package mvc.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mvc.model.Blade;
import mvc.model.Sliceable;

/**
 * Implementation of the user input.
 */
public class BladeImpl implements Blade {

    private final List<Sliceable> activeSliceables;

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
    public void addSliceable(final Sliceable object) {
        this.activeSliceables.add(Objects.requireNonNull(object));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteSliceable(final Sliceable object) {
        this.activeSliceables.remove(Objects.requireNonNull(object));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifySliceable(final Sliceable slicedObject) {
        if (this.getSliceable(slicedObject) != null) {
            slicedObject.update();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sliceable> getActiveSliceables() {
        return new ArrayList<>(this.activeSliceables);
    }

    /**
     * @param object
     * @return the specified object (if present) from the list.
     */
    private Sliceable getSliceable(final Sliceable object) {
        Objects.requireNonNull(object);
        if (this.activeSliceables.contains(object)) {
            return object;
        }
        return null;
    }

}
