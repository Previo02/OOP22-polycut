package mvc.model.impl;

import java.awt.geom.Point2D;
import java.util.Random;

import mvc.model.SliceableFactory;

/**
 * {@inheritDoc}.
 */
public class SliceableFactoryImpl implements SliceableFactory {
    private static final Integer RADIUS = 10;
    private static final Integer GROUND = 0;
    private static final Random RANDOM = new Random();
    private Point2D startPositionNext;
    private Point2D startVelocityNext;

    /**
     * Calculates all the different information regarding the spawn of new sliceable (position, velocity?).
     */
    private void doCalc() {
        /*TODO velocity and positions numbers still unknown without world and scene*/
        this.startVelocityNext = new Point2D.Double(RANDOM.nextDouble(10), RANDOM.nextDouble(10));
        this.startPositionNext = new Point2D.Double(RANDOM.nextDouble(10), GROUND);
    }

    /**
     * {@inheritDoc}
     * @return new Bomb
     */
    @Override
    public BombImpl createBomb() {
        this.doCalc();
        return new BombImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }

    /**
     * {@inheritDoc}
     * @return new Polygon
     */
    @Override
    public PolygonImpl createPolygon() {
        this.doCalc();
        return new PolygonImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }
}
