package mvc.view;

import java.awt.geom.Point2D;

/**
 * 
 */
public interface SliceableView {

    // Utilizzare GetBorder per parte controller
    /**
     * 
     * @param isSliced
     */
    void changeVisibility(boolean isSliced);

    /**
     * 
     * @return the center of the image.
     */
    boolean isVisible();

    /**
     * 
     * @return the center of the image.
     */
    Point2D getPosition();

    /**
     * 
     * @param position
     */
    void setSliaceablePosition(Point2D position);

    /**
     * 
     */
    void setSliceStatus();

}
