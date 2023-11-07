package mvc.model;

import java.util.List;

/**
 * Blade class, it contains all the methods useful for managing the correct interation
 * between the user input and the Sliceable objects according to the Observer pattern.
 */
public interface Blade {

    /**
     * Adds an active sliceable object.
     * @param object added to list.
     */
    void addSliceable(SliceableModel object);

    /**
     * Deletes a sliceable object from the list of active sliceable objects.
     * @param object delete from list
     */
    void deleteSliceable(SliceableModel object);

    /**
     * @return a list of active sliceable objects.
     */
    List<SliceableModel> getActiveSliceables();

}
