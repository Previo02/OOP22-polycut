package mvc.model;

/**
 * Factory pattern used to create different Sliceable objects: bombs and polygons.
 * It simplifies the multiple creation of objects.
 */
public interface SliceableFactory {
    /**
     * The principal method of the class, the one called by the game world when in need to create
     * a new sliceable.
     * @return new Sliceable.
     */
    Sliceable create();
}
