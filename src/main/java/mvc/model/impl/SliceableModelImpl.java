package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.Objects;
import mvc.model.SliceableModel;
import mvc.model.SliceableTypeEnum;

/**
 * {@inheritDoc}.
 */
public class SliceableModelImpl implements SliceableModel {
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer BOMB = -1;
    private static final Integer LOWER_BOUND = 1000;
    private Point2D position;
    private final Integer sides;
    private Point2D velocity;
    private boolean isSliced;
    private final int sliceableId;

    /**
     * Constructor of a regular polygon.
     * 
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
    public boolean isSliced() {
        return this.isSliced;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void setSliced() {
        this.isSliced = true;
    }

    /**
     * {@inheritDoc}.
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
     * {@inheritDoc}.
     */
    @Override
    public SliceableTypeEnum getSides() {
        if (Objects.equals(this.sides, BOMB)) {
            return SliceableTypeEnum.BOMB;
        } else if (Objects.equals(this.sides, THREE)) {
            return SliceableTypeEnum.TRIANGLE;
        } else if (Objects.equals(this.sides, FOUR)) {
            return SliceableTypeEnum.SQUARE;
        } else if (Objects.equals(this.sides, FIVE)) {
            return SliceableTypeEnum.PENTAGON;
        } else {
            return SliceableTypeEnum.HEXAGON;
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isOutOfBound() {
        return this.getPosition().getY() > LOWER_BOUND;
    }
}
