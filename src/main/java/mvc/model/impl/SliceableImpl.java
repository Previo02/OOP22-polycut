package mvc.model.impl;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.io.Serial;

import mvc.model.Sliceable;

/**
 * {@inheritDoc}.
 */
public class SliceableImpl extends Polygon implements Sliceable {

    @Serial
    private static final long serialVersionUID = 0L;
    private Point2D position;
    private Point2D velocity;
    private boolean isSliced;

    /**
     * Constructor of a regular polygon.
     * 
     * @param nsides   number of sides of the sliceable polygon.
     * @param radius   distance between the center of the sliceable and the
     *                 vertices.
     * @param position Point2D position of the sliceable, to update every timestep.
     * @param velocity Point2D vector of the new velocity of the object.
     */
    public SliceableImpl(final Integer nsides, final Integer radius, final Point2D position, final Point2D velocity) {
        this.velocity = new Point2D.Double(velocity.getX(), velocity.getY());
        this.position = new Point2D.Double(position.getX(), position.getY());
        this.npoints = nsides;
        this.xpoints = new int[nsides];
        this.ypoints = new int[nsides];

        final double theta = 2.0 * Math.PI / nsides;

        for (int i = 0; i < nsides; i++) {
            final double x = radius * Math.cos(i * theta);
            final double y = radius * Math.sin(i * theta);
            xpoints[i] = (int) Math.round(x);
            ypoints[i] = (int) Math.round(y);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point2D getPosition() {
        return new Point2D.Double(this.position.getX(), this.position.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Point2D position) {
        this.position = new Point2D.Double(position.getX(), position.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point2D getVelocity() {
        return new Point2D.Double(this.velocity.getX(), this.velocity.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVelocity(final Point2D velocity) {
        this.velocity = new Point2D.Double(velocity.getX(), velocity.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSliced() {
        return this.isSliced;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSliced() {
        this.isSliced = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cut() {
        if (this.isSliced()) {
            return false;
        }
        this.setSliced();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        /* TODO manage the logic when the polygon is sliced. */
    }

}
