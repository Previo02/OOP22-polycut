package mvc.model.impl;

import java.awt.geom.Point2D;

/**
 * Polygon Implementation.
 */
public class PolygonImpl extends SliceableModelImpl {

    /**
     * Constructor of a polygon.
     * @param nsides number of sides of the sliceable polygon.
     * @param position Point2D position of the sliceable, to update every timestep.
     * @param velocity Point2D vector of the new velocity of the object.
     * @param sliceableId the sliceable identifier.
     */
    public PolygonImpl(final Integer nsides, final Point2D position,
                       final Point2D velocity, final int sliceableId) {
        super(nsides, position, velocity, sliceableId);
    }
}
