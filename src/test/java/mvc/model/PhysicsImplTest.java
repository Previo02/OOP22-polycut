package mvc.model;

import org.junit.jupiter.api.Test;

import mvc.model.impl.PhysicsImpl;
import mvc.model.impl.SliceableModelImpl;

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
        final SliceableModel test = new SliceableModelImpl(3, new Point2D.Double(100, 100), new Point2D.Double(10, 10), 0);
        final Physics physics = new PhysicsImpl(DT);

        /*Creating the list and executing the correct math on the polygons*/
        final List<SliceableModel> list = new ArrayList<>();
        list.add(test);
        physics.doMaths(list);

        /*Asserting the result obtained with the correct result polygon created*/
        final SliceableModel result = new SliceableModelImpl(3, new Point2D.Double(101, 99), new Point2D.Double(10, 9.019), 0);
        assertEquals(result.getPosition(),  test.getPosition());
        assertEquals(result.getVelocity(),  test.getVelocity());
    }
}
