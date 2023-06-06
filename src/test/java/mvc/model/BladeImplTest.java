package mvc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import mvc.model.impl.BladeImpl;
import mvc.model.impl.BombImpl;

class BladeImplTest {

    private final Blade blade = new BladeImpl();
    private final BombImpl b1 = new BombImpl(4, 2, new Point2D.Double(0, 0), new Point2D.Double(7, 7));
    private final BombImpl b2 = new BombImpl(7, 4, new Point2D.Double(0, 0), new Point2D.Double(7, 7));
    private final BombImpl b3 = new BombImpl(7, 4, new Point2D.Double(0, 0), new Point2D.Double(7, 7));

    @Test
    void addSliceableTest() {
        blade.addSliceable(b1);
        blade.addSliceable(b2);
        blade.addSliceable(b3);
        assertEquals(new ArrayList<>(List.of(b1, b2, b3)), blade.getActiveSliceables());
    }

    @Test
    void deleteSliceableTest() {
        blade.addSliceable(b1);
        blade.addSliceable(b2);
        blade.deleteSliceable(b1);
        assertEquals(new ArrayList<>(List.of(b2)), blade.getActiveSliceables());
    }

}
