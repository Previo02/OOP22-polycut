package mvc.view;

import java.awt.geom.Point2D;
import java.util.List;

import mvc.model.SliceableTypeEnum;

/**
 * GameArea interface, models methods for drawing and updating sliceables.
 */
public interface GameArea {

    /**
     * Create The Sliceable and attach the listener.
     * @param sliceableID the ID of the object
     * @param position the initial position
     * @param type of Sliceable, to manage mouse listener and dimensions
     */
    void drawSliceable(Integer sliceableID, Point2D position, SliceableTypeEnum type);

    /**
     * Update the position of the sliceable.
     * @param newPosition of the sliceable
     * @param type of the sliceable to manage dimensions
     */
    void updatePosition(Point2D newPosition, SliceableTypeEnum type);

    /**
     * Clean the area.
     * @param sliceableID the object to remove
     */
    void clean(Integer sliceableID);

    /**
     * @return a list of ID of sliced elements.
     */
    List<Integer> getSliced();
}
