package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.Random;

import mvc.model.SliceableFactory;

/**
 * {@inheritDoc}.
 */
public class SliceableFactoryImpl implements SliceableFactory {
    private static final Integer RADIUS = 10;
    private static final Random RANDOM = new Random();
    private static final Integer SPAWN_X = 300;
    private Point2D startPositionNext;
    private Point2D startVelocityNext;

    /**
     * Calculates all the different information regarding the spawn of new sliceable (position, velocity).
     */
    private void doCalc() {
        this.startVelocityNext = new Point2D.Double(RANDOM.nextDouble(25, 50),
                RANDOM.nextDouble(50, 100));
        this.startPositionNext = new Point2D.Double(RANDOM.nextInt(SPAWN_X), 650);
    }

    /**
     * {@inheritDoc}.
     * @return new Bomb
     */
    @Override
    public BombImpl createBomb() {
        this.doCalc();
        return new BombImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }

    /**
     * {@inheritDoc}.
     * @return new Polygon
     */
    @Override
    public PolygonImpl createPolygon() {
        this.doCalc();
        return new PolygonImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }
}
