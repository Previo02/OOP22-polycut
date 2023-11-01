package mvc.controller.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameLoop;
import mvc.model.SliceableModel;
import mvc.view.impl.GameScreen;
import mvc.view.GameArea;

import javax.swing.JLabel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* Implementation class of GameLoop interface.
* Check the relative interface for the documentation.
*/
public class GameLoopImpl implements GameLoop {

    private static final Double DT = 1.0;
    private static final Integer DELAY = (int) (1000 * DT);
    private static final Double PERCENTAGE = 0.3;
    private static final Random RANDOM = new Random();

    private final GameWorldControllerImpl world;
    private final PhysicControllerImpl physics;
    private final List<JLabel> labelList;

    /**
    * Constructor.
    * @param world game world controller.
    * @param screen the GameScreen.
    */
    @SuppressFBWarnings
    public GameLoopImpl(final GameWorldControllerImpl world, final GameScreen screen) {
        this.world = world;
        this.physics = new PhysicControllerImpl(DT, world);
        this.labelList = new ArrayList<>();
        final GameArea area = screen.createAndShowGui();

        // settings up the 2 timers, 1 for the object spawn and the other for the redrawing process
        final Timer gameTimer = new Timer(DELAY, e -> loop(area));
        final Timer redrawTimer = new Timer(30, e -> {
            physics.updateSliceablesPosition();
            for (final var sliceable : this.world.getSliceables()) {
                for (final var label : this.labelList) {
                    area.updatePosition(label, sliceable.getPosition(), sliceable.getSides());
                }
            }
        });
        redrawTimer.setRepeats(true);
        redrawTimer.start();
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
   public void loop(final GameArea area) {
        final var polygons = this.world.getPolygons();
        final var bombs = this.world.getBombs();
        final double choice = RANDOM.nextDouble(1);

        if (choice < PERCENTAGE) {
            int id;
            SliceableModel bomb;
            do {
                id = RANDOM.nextInt();
                bomb = world.createBomb(id);
            } while (bombs.contains(bomb));
            // System.out.println("Bomba creata");
        } else {
            int id;
            SliceableModel polygon;
            do {
                id = RANDOM.nextInt();
                polygon = world.createPolygon(id);
            } while (polygons.contains(polygon));
            // System.out.println("Poligono creato");
        }

         final Timer redrawTimer = new Timer(DELAY, e -> {
            for (final var sliceable : this.world.getSliceables()) {
                if (sliceable.isOutOfBound()) {
                    final int sliceableId = sliceable.getSliceableId();
                    world.outOfBoundDelete(sliceableId);
                }
                final var sliceLabel = area.drawSliceable(sliceable.getPosition(), sliceable.getSides());
                this.labelList.add(sliceLabel);
            }
        });
        redrawTimer.setRepeats(true);
        redrawTimer.start();
    }

}
