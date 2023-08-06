package mvc.controller;

import java.util.List;

import mvc.model.Sliceable;

/**
 * Main controller of the game. Manages all the model and view of the game.
 */
public interface GameWorldController {
  
    /**
     * @return a list of the current sliceables in game.
     */
    List<Sliceable> getVisibleSliceables();

    /**
     * Update the current list of sliceables with a new one (this is used by PhysicsController).
     * @param updatedList
     */
    void setVisibleSliceables(List<Sliceable> updatedList);

    /**
     * Creates a random amount of sliceables.
     */
    void createSliceables();
}
