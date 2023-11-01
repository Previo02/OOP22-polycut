package mvc.controller;

import java.util.List;

import mvc.model.SliceableModel;

/**
 * Main controller of the game. Manages all the model and view of the game.
 */
public interface GameWorldController {
    /**
     * @return a list of the polygons in game.
     */
    List<SliceableModel> getPolygons();

    /**
     * Update the current list of polygons with a new one.
     * @param updatedList the new list.
     */
    void setPolygons(List<SliceableModel> updatedList);

    /**
     * Getter of the bombs.
     * @return a list of the bombs in game.
     */
    List<SliceableModel> getBombs();

    /**
     * Update the current list of bombs with a new one.
     * @param updatedList the new list.
     */
    void setBombs(List<SliceableModel> updatedList);

    /**
     * Creates a single polygon.
     * @param polygonId the polygon identifier.
     * @return the newly created polygon.
     */
    SliceableModel createPolygon(int polygonId);

    /**
     * Creates a single bomb.
     * @param bombId the bomb identifier.
     * @return the newly created bomb.
     */
    SliceableModel createBomb(int bombId);

    /**
     * Initialize the game screen and starts the game loop.
     */
    void startLoop();

    /**
     * 
     * @param sliceableId
     */
    void outOfBoundDelete(int sliceableId);

    /**
     * 
     * @param bomb
     */
    void addBomb(SliceableModel bomb);

    /**
     * 
     * @param polygon
     */
    void addPolygon(SliceableModel polygon);

    /**
     * Creates a new list from the concatenation of bombs and sliceables.
     * @return a list of all sliceables
     */
    List<SliceableModel> getSliceables();

}
