package mvc.model;

/**
 * Bomb class, extends SliceableImpl with the method cut() that causes a lost life.
 */
public interface Bomb {
    /**
     * Cut method, used with the collision. It loses a life if the object cut is a bomb.
     */
    void cut();
}
