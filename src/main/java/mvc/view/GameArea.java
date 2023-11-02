package mvc.view;

import java.awt.geom.Point2D;

import mvc.model.SliceableTypeEnum;

/**
 * GameArea interface, models methods for drawing and updating sliceables.
 */
public interface GameArea {

    /**
     * Create The Sliceable and attach the listener.
     * @param position the initial position
     * @param type of Sliceable, to manage mouse listener and dimensions
     */
    void drawSliceable(Point2D position, SliceableTypeEnum type);

    /**
     * Update the position of the sliceable.
     * @param newPosition of the sliceable
     * @param type of the sliceable to manage dimensions
     */
    void updatePosition(Point2D newPosition, SliceableTypeEnum type);
}
