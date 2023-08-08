package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameLoop;
import mvc.model.Sliceable;
import mvc.view.impl.GameScreen;
import mvc.view.impl.GameArea;

import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.awt.event.ActionEvent;

/**
 * Implementation class of GameLoop inteface.
 * Check the relative interface for the documentation.
 */
public class GameLoopImpl implements GameLoop {

    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;

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
     * {@inheritDoc}
     */
    @Override
    public void loop(final GameScreen screen) {
        final GameArea area = screen.createAndShowGui();
        final int nPoly = 5;

            for (int i = 0; i < nPoly; i++) {
                final Sliceable slice = world.createPolygon(i);
                area.addPolygon(slice.getPosition(), slice.getSides(), i);
            }
            final Sliceable bomb = world.createBomb(0);
            area.addBomb(bomb.getPosition(), 0);
            startRedrawTimer(area, 100);
        }

    /**
     * Creates a timer for the rendering of the sliceables.
     * @param area the game area where the polygons are displayed.
     * @param delay
     */
    private void startRedrawTimer(final GameArea area, final int delay) {
        final Timer redrawTimer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                physics.updateSliceablesPosition();
                /* Updates the new position of the polygons model congruently to their view. */
                for (final var polyModel : world.getPolygons()) {
                    for (final var polyView : area.getPolygons()) {
                        if (polyModel.getSliceableId() == polyView.getPolygonId()) {
                            polyView.setPosition(polyModel.getPosition());
                        }
                    }
                }
                /* Now for the bombs. */
                for (final var polyModel : world.getBombs()) {
                    for (final var polyView : area.getBombs()) {
                        if (polyModel.getSliceableId() == polyView.getPolygonId()) {
                            polyView.setPosition(polyModel.getPosition());
                        }
                    }
                }
                area.repaint();
            }

        });
        redrawTimer.setRepeats(true);
        redrawTimer.start();
    }

}
