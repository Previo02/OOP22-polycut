package mvc.model;

import org.junit.jupiter.api.Test;

import mvc.model.impl.PhysicsImpl;
import mvc.model.impl.SliceableImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

class PhysicsImplTest {

    static final double DT = 0.1;

    /**
     * Test method of the Physics implementation, it calculates the new position of a basic, given polygon.
     * It asserts that the new coordinates are equal to the correct ones given.
     */
    @Test
    void doMathsTest() {
        /*Creating a new test polygon and PhysicsImpl.*/
        final Sliceable test = new SliceableImpl(3, 1, new Point2D.Double(0, 0), new Point2D.Double(10, 10));
        final Physics physics = new PhysicsImpl(DT);

        /*Creating the list and executing the correct math on the polygons*/
        final List<Sliceable> list = new ArrayList<>();
        list.add(test);
        physics.doMaths(list);

        /*Asserting the result obtained with the correct result polygon created*/
        final Sliceable result = new SliceableImpl(3, 1, new Point2D.Double(1, 1), new Point2D.Double(10, 9.019));
        assertEquals(result.getPosition(),  test.getPosition());
        assertEquals(result.getVelocity(),  test.getVelocity());
    }
}
