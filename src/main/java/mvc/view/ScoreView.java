package mvc.view;

/**
 * Interface that represents the Player's score.
 */
public interface ScoreView {

    /**
     * Gets the shown player's score.
     * @return The score of the Player.
     */
    int getScore();

    /**
     * Draw the new score.
     */
    void drawScore();

    /**
     * Increease the player's score.
     */
    void increaseScore();
}
