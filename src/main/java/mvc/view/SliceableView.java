package mvc.view;

import java.awt.geom.Point2D;

/**
 * Interface that represent a sliceable (polygons/bombs).
 */
public interface SliceableView {

    // Utilizzare GetBorder per parte controller

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

    /**
     * @return the identifier of the current polygon.
     */
    int getSliceableId();
}
