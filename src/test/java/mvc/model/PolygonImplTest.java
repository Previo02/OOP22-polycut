package mvc.model;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolygonImplTest {

    private final PolygonImpl testPoly = new PolygonImpl(4, 2, new Point2D.Double(0, 0), new Point2D.Double(7, 7));


    /**
     * Test method of the PolygonImpl class, used to test the cut method. It increments the total point
     * and causes the Polygon to be sliced.
     */
    @Test
    void cutTest() {
        testPoly.cut();
        assertTrue(testPoly.isSliced());
        assertFalse(testPoly.cut());
        /*TODO gain points, after world creation*/
    }
}
