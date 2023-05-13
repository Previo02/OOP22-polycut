package mvc.model;

import java.awt.geom.Point2D;

/**
 * SliceableImpl class, creates the bombs and the polygon for the game.
 */
public interface Sliceable {

    /**
     * Position getter.
     *
     * @return position
     */
    Point2D getPosition();

    /**
     * Position setter.
     * @param position updated by the physics class.
     */
    void setPosition(Point2D position);

    /**
     * Velocity getter.
     * @return velocity
     */
    Point2D getVelocity();

    /**
     * Velocity setter.
     * @param velocity updated by the physics class.
     */
    void setVelocity(Point2D velocity);

    /**
     * isSliced getter.
     * @return isSliced
     */
    boolean isSliced();

    /**
     * isSliced setter, used when the sliceable object is cut.
     */
    void setSliced();

    /**
     * Cut method of the class. It sets the isSliced to true, it loses a life if called on a Bomb, it gains
     * points if it is called on a Polygon.
     * @return boolean, if the sliceable was cut or not.
     */
    boolean cut();
}
