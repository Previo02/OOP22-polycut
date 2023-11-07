package mvc.view;

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
}
