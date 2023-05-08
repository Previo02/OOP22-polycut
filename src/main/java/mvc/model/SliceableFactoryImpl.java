package mvc.model;

import java.awt.geom.Point2D;
import java.util.Random;

/**
 * {@inheritDoc}.
 */
public class SliceableFactoryImpl implements SliceableFactory {

    private static final Double PERCENTAGE = 0.2;
    private static final Integer RADIUS = 10;
    private static final Random RANDOM = new Random();
    private Point2D startPositionNext;
    private Point2D startVelocityNext;
    private boolean isBombNext;

    /**
     * Decide if the next object will be a bomb or a polygon.
     */
    private void decideVersion() {
        if (Math.random() <= PERCENTAGE) {
            this.isBombNext = true;
        }
    }

    /**
     * Creates a sliceable Polygon.
     * @return new Polygon.
     * @param startPositionNext the starting point of the next Bomb.
     * @param startVelocityNext the starting velocity of the next Bomb:
     */
    private PolygonImpl createPolygon(final Point2D startPositionNext, final Point2D startVelocityNext) {
        return new PolygonImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }

    /**
     * Creates a new Bomb.
     * @return new Bomb.
     * @param startPositionNext the starting point of the next Bomb.
     * @param startVelocityNext the starting velocity of the next Bomb.
     */
    private BombImpl createBomb(final Point2D startPositionNext, final Point2D startVelocityNext) {
        return new BombImpl(RANDOM.nextInt(8 - 3 + 1) + 3, RADIUS, startPositionNext, startVelocityNext);
    }

    /**
     * Calculates all the different information regarding the spawn of new sliceable (position, velocity?).
     */
    private void doCalc() {
    this.startVelocityNext = new Point2D.Double(RANDOM.nextDouble(/*TODO*/), RANDOM.nextDouble(/*TODO*/));
    this.startPositionNext = new Point2D.Double(RANDOM.nextDouble(/*TODO*/), RANDOM.nextDouble(/*TODO*/));
    }

    /**
     * {@inheritDoc}.
     * @return
     */
    @Override
    public Sliceable create() {
        SliceableImpl sliceableCreated;
        this.doCalc();
        this.decideVersion();
        if (this.isBombNext) {
            sliceableCreated = createBomb(this.startPositionNext, this.startVelocityNext);
        } else {
             sliceableCreated =  createPolygon(this.startPositionNext, this.startVelocityNext);
        }
        return sliceableCreated;

    }
}
