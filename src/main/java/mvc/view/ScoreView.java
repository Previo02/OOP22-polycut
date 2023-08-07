package mvc.view;

/**
 * Interface that represents the Player's score.
 */
public interface ScoreView {

    /**
     * Gets the shown player's score.
     * @return The score of the Player.
     */
    Integer getScore();

    /**
     * Sets the player's score.
     * @param score To set in the label.
     */
    void setScore(Integer score);
    /**
     * Print the current player's score on the screen.
     */
    void printScore();
}
