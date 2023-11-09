package mvc.view;

import mvc.view.impl.LiveImpl;

/**
 * Interface that defines the player's life.
 */
public interface Live {
    /**
     * Decrease the current lives.
     */
    void decreaseLives();

    /**
     * Getter for livesCounter.
     *
     * @return The number of remaining lives.
     */
    int getLivesCounter();

    /**
     * @return the istance of the class. Used to resolve spotbugs errors.
     */
    LiveImpl getCurrLiveImpl();
}
