package mvc.view;

/**
 * Interface that represents the Player's score
 */
public interface Score {

    /**
     * Gets the shown player's score
     * @return The score of the Player
     */
    int getScore();

    /**
     * Sets the player's score
     * @param score To set in the label
     */
    void setScore(int score);
    /**
     * Print the current player's score on the screen
     */
    void printScore();
}
