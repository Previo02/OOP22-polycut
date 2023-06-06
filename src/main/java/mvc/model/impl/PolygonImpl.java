package mvc.model.impl;

import java.awt.geom.Point2D;
import java.io.Serial;

/**
 * {@inheritDoc}.
 */
public class PolygonImpl extends SliceableImpl {
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Constructor of a polygon.
     *
     * @param nsides number of sides of the sliceable polygon.
     * @param radius distance between the center of the sliceable and the vertices.
     * @param position Point2D position of the sliceable, to update every timestep.
     * @param velocity Point2D vector of the new velocity of the object.
     */
    public PolygonImpl(final Integer nsides, final Integer radius, final Point2D position, final Point2D velocity) {
        super(nsides, radius, position, velocity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cut() {
        if (!this.isSliced()) {
            this.setSliced();
            /*TODO increasePoint()*/
            return true;
        }
        return false;
    }

}
