package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.Random;

import mvc.model.SliceableFactory;

/**
 * {@inheritDoc}.
 */
public class SliceableFactoryImpl implements SliceableFactory {
//    private static final Integer RADIUS = 10;
    private static final Random RANDOM = new Random();
    private static final Integer SPAWN_X = 400;
    private static final Integer SPAWN_Y = 750;
    private static final Integer VEL_X_ORIGIN = 35;
    private static final Integer VEL_X_BOUND = 40;
    private static final Integer VEL_Y_ORIGIN = 85;
    private static final Integer VEL_Y_BOUND = 115;
    private Point2D startPositionNext;
    private Point2D startVelocityNext;

    /**
     * Calculates all the different information regarding the spawn of new sliceable (position, velocity).
     */
    private void doCalc() {
        this.startVelocityNext = new Point2D.Double(RANDOM.nextDouble(VEL_X_ORIGIN, VEL_X_BOUND),
                RANDOM.nextDouble(VEL_Y_ORIGIN, VEL_Y_BOUND));
        this.startPositionNext = new Point2D.Double(RANDOM.nextInt(SPAWN_X), SPAWN_Y);
    }

    /**
     * {@inheritDoc}.
     * @return new Bomb
     */
    @Override
    public BombImpl createBomb(final int bombId) {
        this.doCalc();
        return new BombImpl(RANDOM.nextInt(8 - 3 + 1) + 3, startPositionNext, startVelocityNext, bombId);
    }

    /**
     * {@inheritDoc}.
     * @return new Polygon
     */
    @Override
    public PolygonImpl createPolygon(final int polygonId) {
        this.doCalc();
        return new PolygonImpl(RANDOM.nextInt(8 - 3 + 1) + 3, startPositionNext, startVelocityNext, polygonId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLowerBound() {
        return SPAWN_Y;
    }
}
