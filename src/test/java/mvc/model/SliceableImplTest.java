package mvc.model;

import org.junit.jupiter.api.Test;

import mvc.model.impl.SliceableImpl;

import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SliceableImplTest {
    private final SliceableImpl test = new SliceableImpl(4, 2, new Point2D.Double(0, 0), new Point2D.Double(10, 10));
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
        test.setPosition(testVel);
        assertEquals(test.getPosition(), testVel);
    }

    /**
     * isSliced tester, controls the getter.
     */
    @Test
    void isSlicedTest() {
        assertFalse(test.isSliced());
        test.setSliced();
        assertTrue(test.isSliced());
    }

    /**
     * isSliced tester, controls the setter.
     */
    @Test
    void setSlicedTest() {
        test.setSliced();
        assertTrue(test.isSliced());
    }
}
