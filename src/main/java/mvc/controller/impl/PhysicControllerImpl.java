package mvc.controller.impl;

import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.controller.GameWorldController;
import mvc.controller.PhysicController;
import mvc.model.Physics;
import mvc.model.Sliceable;
import mvc.model.impl.PhysicsImpl;

/**
 * 
 */
public class PhysicControllerImpl implements PhysicController {

    private final Physics physicsModel;
    private final GameWorldController gameController;

    /**
     * Constructor of the Physics Controller.
     * @param dt delta time
     * @param gameController game controller
     */
    @SuppressFBWarnings
    public PhysicControllerImpl(final int dt, final GameWorldController gameController) {
        this.physicsModel = new PhysicsImpl(dt);
        this.gameController = gameController;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void updateSliceablesPosition() {
        final List<Sliceable> currentPolygons = this.gameController.getPolygons();
        final List<Sliceable> currentBombs = this.gameController.getBombs();
        this.physicsModel.doMaths(currentPolygons);
        this.physicsModel.doMaths(currentBombs);
        this.gameController.setPolygons(currentPolygons);
        this.gameController.setBombs(currentBombs);
    }

}
