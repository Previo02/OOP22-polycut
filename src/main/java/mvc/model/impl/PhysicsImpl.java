package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.List;

import mvc.model.Physics;
import mvc.model.SliceableModel;

/**
 * {@inheritDoc}.
 */
public class PhysicsImpl implements Physics {
    static final Point2D GRAVITY = new Point2D.Double(0, 9.81);
    private final double dt;

    /**
     * {@inheritDoc}.
     * @param dt
     */
    public PhysicsImpl(final double dt) {
        this.dt = dt;
    }

    /**
     * {@inheritDoc}
     * @param listPolygon
     */
    @Override
    public void doMaths(final List<SliceableModel> listPolygon) {
        for (final SliceableModel poly : listPolygon) {
            final var oldPos = poly.getPosition();
            final var oldVel = poly.getVelocity();

            final double velX = oldVel.getX() + dt * GRAVITY.getX();
            final double velY = oldVel.getY() - dt * GRAVITY.getY();
            final var newVel = new Point2D.Double(velX, velY);

            final double posX = oldPos.getX() + dt * oldVel.getX();
            final double posY = oldPos.getY() - dt * oldVel.getY();
            final var newPos = new Point2D.Double(posX, posY);

            poly.setPosition(newPos);
            poly.setVelocity(newVel);
        }
    }

}
