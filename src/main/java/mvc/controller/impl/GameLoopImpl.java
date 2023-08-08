package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameLoop;
import mvc.model.Sliceable;
import mvc.view.impl.GameScreen;
//import mvc.view.impl.LiveImpl;
//import mvc.view.impl.ScoreViewImpl;
import mvc.view.impl.GameArea;

import javax.swing.SwingUtilities;
import java.util.List;

/**
 * {@inheritDoc}.
 */
public class GameLoopImpl implements GameLoop {

    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;
    //private final LiveImpl lives = new LiveImpl();
    //private final ScoreViewImpl score = new ScoreViewImpl();

    /**
     * Constructor.
     * @param world game world controller.
     */
    @SuppressFBWarnings
    public GameLoopImpl(final GameWorldControllerImpl world) {
        this.world = world;
        this.physics = new PhysicControllerImpl(1, world);
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public void loop(final GameScreen screen) {
        final GameArea area = screen.createAndShowGui();
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            world.createSliceables();
        }
        while (counter < 30) {
            //world.createSliceables();

            final List<Sliceable> listSliceable = world.getVisibleSliceables();
            listSliceable.forEach(s -> area.addPolygon(s.getPosition(), s.getSides()));

            physics.updateSliceablesPosition();
            SwingUtilities.invokeLater(area::repaint);

            //area.getPolygons().forEach(p -> System.out.println(p.getPosition().getX() + " " + p.getPosition().getY()));
            counter = counter + 1;
        }
    }
}
