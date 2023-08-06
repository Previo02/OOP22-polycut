package mvc.view;

public interface Live {

    /**
     * Get the file Path for the correct amount of lives
     */
    void getCorrectPath(int lifeCounter);

    /**
     * Draws the correct amount of lives on screen
     */
    void drawLives();
}
