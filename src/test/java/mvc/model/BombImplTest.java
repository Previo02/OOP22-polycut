package mvc.model;

import org.junit.jupiter.api.Test;

import mvc.model.impl.BombImpl;

import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BombImplTest {

    private final BombImpl testBomb = new BombImpl(4, new Point2D.Double(0, 0), new Point2D.Double(7, 7), 0);

    /**
     * Test method of the BombImpl class, used to test the cut method, it loses a life
     * and causes the Bomb to be sliced.
     */
    @Test
    void cutTest() {
        testBomb.cut();
        assertTrue(testBomb.isSliced());
        assertFalse(testBomb.cut());
        /*TODO lose life, after world creation*/
    }
}
