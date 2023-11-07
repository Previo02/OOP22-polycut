package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.Random;

import mvc.model.SliceableFactory;

/**
 * {@inheritDoc}.
 */
public class SliceableFactoryImpl implements SliceableFactory {
    private static final Random RANDOM = new Random();

    private static final Integer MAX_SIDES = 4;
    private static final Integer BOMB_SIDES = -1;
    private static final Integer SPAWN_X = 400;
    private static final Integer SPAWN_Y = 750;
    private static final double VEL_X_ORIGIN = 35.0;
    private static final double VEL_X_BOUND = 40.0;
    private static final double VEL_Y_ORIGIN = 85.0;
    private static final double VEL_Y_BOUND = 115.0;
    private Point2D startPositionNext;
    private Point2D startVelocityNext;

    /**
     * Calculates all the different information regarding the spawn of new sliceable (position, velocity).
     */
    private void doCalc() {
        final double randomX = VEL_X_ORIGIN + (VEL_X_BOUND - VEL_X_ORIGIN) * RANDOM.nextDouble();
        final double randomY = VEL_Y_ORIGIN + (VEL_Y_BOUND - VEL_Y_ORIGIN) * RANDOM.nextDouble();

        this.startVelocityNext = new Point2D.Double(randomX, randomY);
        this.startPositionNext = new Point2D.Double(RANDOM.nextInt(SPAWN_X), SPAWN_Y);
    }

    /**
     * {@inheritDoc}.
     * @return new Bomb
     */
    @Override
    public BombImpl createBomb(final int bombId) {
        this.doCalc();
        return new BombImpl(BOMB_SIDES, startPositionNext, startVelocityNext, bombId);
    }

    /**
     * {@inheritDoc}.
     * @return new Polygon
     */
    @Override
    public PolygonImpl createPolygon(final int polygonId) {
        this.doCalc();
        return new PolygonImpl(RANDOM.nextInt(MAX_SIDES) + 3, startPositionNext, startVelocityNext, polygonId);
    }
}
