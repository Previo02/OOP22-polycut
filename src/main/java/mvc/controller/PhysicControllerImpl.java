package mvc.controller;

import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
     * Consctructor of the Physics Controller.
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
        final List<Sliceable> currentSliceables = this.gameController.getVisibleSliceables();

        this.physicsModel.doMaths(currentSliceables);
        this.gameController.setVisibleSliceables(currentSliceables);
    }

}