package mvc.controller;

import java.util.List;

import mvc.model.Sliceable;

/**
 * Main controller of the game. Manages all the model and view of the game.
 */
public interface GameWorldController {
    /**
     * @return a list of the polygons in game.
     */
    List<Sliceable> getPolygons();

    /**
     * Update the current list of polygons with a new one.
     * @param updatedList the new list.
     */
    void setPolygons(List<Sliceable> updatedList);

    /**
     * Getter of the bombs.
     * @return a list of the bombs in game.
     */
    List<Sliceable> getBombs();

    /**
     * Update the current list of bombs with a new one.
     * @param updatedList the new list.
     */
    void setBombs(List<Sliceable> updatedList);

    /**
     * Creates a single polygon.
     * @param polygonId the polygon identifier.
     * @return the newly created polygon.
     */
    Sliceable createPolygon(int polygonId);

    /**
     * Creates a single bomb.
     * @param bombId the bomb identifier.
     * @return the newly created bomb.
     */
    Sliceable createBomb(int bombId);

    /**
     * Initialize the game screen and starts the game loop.
     */
    void startLoop();

}
