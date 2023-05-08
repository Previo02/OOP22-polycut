package mvc.model;

import java.util.List;

/**
 * Physics class of the project, it contains all the methods useful for
 * the update of the position and velocity of the polygons and bombs.
 */
public interface Physics {
    /**
     * Mathematics method of the class, it calculates the new Point2D coordinates of velocity and
     * position in a trajectory.
     * @param listPolygon the list of all the polygons present, in this precise moment, in the game world.
     */
    void doMaths(List<Sliceable> listPolygon);
}
