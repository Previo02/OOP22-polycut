package mvc.controller;

/**
 * Manages the physics of the current list of sliceable on screen.
 */
public interface PhysicController {

    /**
     * Calculates the new position of each sliceable and returns it to the GameWorld controller.
     */
    void updateSliceablesPosition();

}
