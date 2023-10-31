package mvc.model;

import java.util.List;

/**
 * Blade class, it contains all the methods useful for managing the correct interation
 * between the user input and the Sliceable objects according to the Observer pattern.
 */
public interface Blade {

    /**
     * Adds an active sliceable object.
     * @param object
     */
    void addSliceable(Sliceable object);

    /**
     * Deletes a sliceable object from the list of active sliceable objects.
     * @param object
     */
    void deleteSliceable(Sliceable object);

    /**
     * Notifies the specified sliceable object when is cut.
     * @param slicedObject
     */
    void notifySliceable(Sliceable slicedObject);

    /**
     * @return a list of active sliceable objects.
     */
    List<Sliceable> getActiveSliceables();

}
