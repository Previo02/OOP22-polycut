package mvc.view;

/**
 * Live class.
 */
public interface Live {

    /**
     * Get the file Path for the correct amount of lives.
     * @param lifeCounter counter of the current lives.
     */
    void setCorrectPath(Integer lifeCounter);

    /**
     * Draws the correct amount of lives on screen.
     */
    void drawLives();
}
