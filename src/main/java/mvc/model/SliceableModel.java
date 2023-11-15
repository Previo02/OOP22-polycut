package mvc.model;

import java.awt.geom.Point2D;

/**
 * SliceableImpl class, creates the bombs and the polygon for the game.
 */
public interface SliceableModel {

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
     * Sides getter.
     *
     * @return sides
     */
    SliceableTypeEnum getSides();

    /**
     * @return the id of the current sliceable.
     */
    int getSliceableId();

    /**
     * @return true if the sliceable is out of the game area lower bound, false otherwise.
     */
    boolean isOutOfBound();

}
