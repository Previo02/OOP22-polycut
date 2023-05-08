package mvc.model;

/**
 * Polygon class, extends SliceableImpl with the method cut() that causes point increase.
 */
public interface Polygon {
    /**
     * Cut method, used with the collision. It increases the point of the player.
     */
    void cut();
}
