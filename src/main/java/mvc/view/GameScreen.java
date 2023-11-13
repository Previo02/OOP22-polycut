package mvc.view;

import mvc.view.impl.GameAreaImpl;
import mvc.view.impl.LiveImpl;

/**
 * Interface that defines the frame where the game is displayed.
 */
public interface GameScreen {

    /**
     * Prepare the frame that contains all the game's elements.
     * @return GameArea
     */
    GameAreaImpl createAndShowGui();

    /**
     * @return the istance of the lives label.
     */
    LiveImpl getCurrentLives();

    /**
     * @return the score
     */
    int getScoreValue();

    /**
     * Display the GameOver panel.
     */
    void gameOverPanel();

    /**
     * Set the new best score.
     * @param record the new player's record
     */
    void setNewBestScore(int record);

    /**
     * Get the current best score.
     * @return the best score of the player
     */
    int getCurrentBestScore();
}
