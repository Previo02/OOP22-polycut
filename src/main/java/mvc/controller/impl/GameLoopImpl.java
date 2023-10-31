//package mvc.controller.impl;
//
//import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
//import mvc.controller.GameLoop;
//import mvc.model.Sliceable;
//import mvc.view.impl.GameScreen;
//import mvc.view.impl.GameArea;
//
//import javax.swing.Timer;
//import java.util.Random;
//
///**
// * Implementation class of GameLoop interface.
// * Check the relative interface for the documentation.
// */
//public class GameLoopImpl implements GameLoop {
//    private static final Double DT = 0.1;
//    private static final Integer DELAY = (int) (1000 * DT);
//    private final GameWorldControllerImpl world;
//    private final PhysicControllerImpl physics;
//    private static final Random RANDOM = new Random();
//    private static final Double PERCENTAGE = 0.3;
//
//    /**
//     * Constructor.
//     * @param world game world controller.
//     * @param screen the GameScreen.
//     */
//    @SuppressFBWarnings
//    public GameLoopImpl(final GameWorldControllerImpl world, final GameScreen screen) {
//        this.world = world;
//        this.physics = new PhysicControllerImpl(DT, world);
//        final GameArea area = screen.createAndShowGui();
//        setupGameLoop(area);
//    }
//
//    /**
//     * {@inheritDoc}.
//     */
//    @Override
//    public void loop(final GameArea area) {
//        final double choice = RANDOM.nextDouble(1);
//
//        if (choice < PERCENTAGE) {
//            final Sliceable bomb = world.createBomb(0);
//            area.addBomb(bomb.getPosition(), 0);
//        } else {
//            final int id = RANDOM.nextInt(100);
//            final Sliceable slice = world.createPolygon(id);
//            area.addPolygon(slice.getPosition(), slice.getSides(), id);
//        }
//
//        final Timer redrawTimer = new Timer(DELAY, e -> {
//            startRedrawTimer(area);
//            for (final var sliceable : world.getSliceables()) {
//                if (sliceable.isOutOfBound()) {
//                    final int sliceableId = sliceable.getSliceableId();
//                    world.outOfBoundDelete(sliceableId, world.getSliceables(), area.getSliceables());
//                    System.out.println(sliceableId + " " + world.getSliceables().contains(sliceable));
//                }
//            }
//            System.out.println("Model " + world.getSliceables().size());
//            System.out.println("View " + area.getSliceables().size());
//            area.repaint();
//        });
//        redrawTimer.setRepeats(true);
//        redrawTimer.start();
//
//        // startRedrawTimer(area);
//    }
//
//    /**
//     * {@inheritDoc}.
//     * @param area GameArea to be painted.
//     */
//    private void setupGameLoop(final GameArea area) {
//        final Timer gameTimer = new Timer(DELAY, e -> loop(area));
//        gameTimer.setRepeats(true);
//        gameTimer.start();
//    }
//
//    /**
//     * Creates a timer for the rendering of the sliceables.
//     * @param area the game area where the polygons are displayed.
//     */
//    private void startRedrawTimer(final GameArea area) {
//        // final Timer redrawTimer = new Timer(DELAY, e -> {
//            physics.updateSliceablesPosition();
//            /* Updates the new position of the polygons model congruently to their view. */
//            for (final var polyModel : world.getPolygons()) {
//                for (final var polyView : area.getSliceables()) {
//                    if (polyModel.getSliceableId() == polyView.getSliceableId()) {
//                        polyView.setPosition(polyModel.getPosition());
//                    }
//                }
//            }
//            /* Now for the bombs. */
//            for (final var bombModel : world.getBombs()) {
//                for (final var bombView : area.getBombs()) {
//                    if (bombModel.getSliceableId() == bombView.getSliceableId()) {
//                        bombView.setPosition(bombModel.getPosition());
//                    }
//                }
//            }
//            // area.repaint();
//        // });
//        // redrawTimer.setRepeats(true);
//        // redrawTimer.start();
//    }
//}
