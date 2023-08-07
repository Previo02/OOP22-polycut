package mvc.view;

import java.awt.geom.Point2D;

/**
 * Interface that represent a sliceable (polygons/bombs).
 */
public interface Sliceable {

    // Utilizzare GetBorder per parte controller

    /**
     * Change slice status.
     * @param isSliced True if has been sliced.
     */

    void changeVisibility(boolean isSliced);

    /**
     * Get visibility.
     * @return True if it's visible on screen.
     */
    boolean isVisible();

    /**
     * @return the top-left corner of the image.
     */
    Point2D getPosition();

    /**
     * Set position of the sliceable.
     * @param position top-left corner.
     */
    void setSliceablePosition(Point2D position);

    /**
     * Set the status sliced.
     */
    void setSliceStatus();
}
