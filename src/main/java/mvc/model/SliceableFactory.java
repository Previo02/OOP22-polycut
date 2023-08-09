package mvc.model;

/**
 * Factory pattern used to create different Sliceable objects: bombs and polygons.
 * It simplifies the multiple creation of objects.
 */
public interface SliceableFactory {
    /**
     * The principal method of the class, the one called by the game world when in need to create
     * a new Bomb.
     * @param bombId
     * @return new Sliceable.
     */
     Sliceable createBomb(int bombId);

    /**
     * The principal method of the class, the one called by the game world when in need to create
     * a new Polygon.
     * @param polygonId
     * @return new Polygon.
     */
    Sliceable createPolygon(int polygonId);
}
