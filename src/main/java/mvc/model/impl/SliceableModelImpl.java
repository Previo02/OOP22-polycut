package mvc.model.impl;

import java.awt.geom.Point2D;
import mvc.model.SliceableModel;
import mvc.model.SliceableTypeEnum;

/**
 * {@inheritDoc}.
 */
public class SliceableModelImpl implements SliceableModel {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int BOMB = -1;
    private static final Integer LOWER_BOUND = 1000;
    private Point2D position;
    private final Integer sides;
    private Point2D velocity;
    private final int sliceableId;

    /**
     * Constructor of a regular polygon.
     * @param nsides   number of sides of the sliceable polygon.
     * @param position Point2D position of the sliceable, to update every timestep.
     * @param velocity Point2D vector of the new velocity of the object.
     * @param sliceableId the sliceable identifier.
     */
    public SliceableModelImpl(final Integer nsides, final Point2D position,
                              final Point2D velocity, final int sliceableId) {
        this.velocity = new Point2D.Double(velocity.getX(), velocity.getY());
        this.position = new Point2D.Double(position.getX(), position.getY());
        this.sides = nsides;
        this.sliceableId = sliceableId;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Point2D getPosition() {
        return new Point2D.Double(this.position.getX(), this.position.getY());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setPosition(final Point2D position) {
        this.position = new Point2D.Double(position.getX(), position.getY());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int getSliceableId() {
        return sliceableId;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Point2D getVelocity() {
        return new Point2D.Double(this.velocity.getX(), this.velocity.getY());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setVelocity(final Point2D velocity) {
        this.velocity = new Point2D.Double(velocity.getX(), velocity.getY());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public SliceableTypeEnum getSides() {
        return switch (this.sides) {
            case BOMB -> SliceableTypeEnum.BOMB;
            case THREE -> SliceableTypeEnum.TRIANGLE;
            case FOUR -> SliceableTypeEnum.SQUARE;
            case FIVE -> SliceableTypeEnum.PENTAGON;
            default -> SliceableTypeEnum.HEXAGON;
        };
    }


    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isOutOfBound() {
        return this.getPosition().getY() > LOWER_BOUND;
    }
}
