package mvc.model;

import org.junit.jupiter.api.Test;

import mvc.model.impl.SliceableModelImpl;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolygonTest {
    private final SliceableModelImpl test = new SliceableModelImpl(4, new Point2D.Double(0, 0), new Point2D.Double(10, 10), 1);
    static final double TEST_VALUE = 15;

    /**
     * Position tester, controls the getter.
     */
    @Test
    void testGetPosition() {
        assertEquals(test.getPosition(), new Point2D.Double(0, 0));
    }

    /**
     * Velocity tester, controls the getter.
     */
    @Test
    void testGetVelocity() {
        assertEquals(test.getVelocity(), new Point2D.Double(10, 10));
    }

    /**
     * Position tester, controls the setter.
     */
    @Test
    void setPositionTest() {
        final Point2D testPos = new Point2D.Double(TEST_VALUE, TEST_VALUE);
        test.setPosition(testPos);
        assertEquals(test.getPosition(), testPos);
    }

    /**
     * Velocity tester, controls the setter.
     */
    @Test
    void setVelocityTest() {
        final Point2D testVel = new Point2D.Double(TEST_VALUE, TEST_VALUE);
        test.setVelocity(testVel);
        assertEquals(test.getVelocity(), testVel);
    }

    /**
     * ID getter tester.
     */
    @Test
    void testGetID() {
        assertEquals(test.getSliceableId(), 1);
    }
}
