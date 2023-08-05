package mvc.view;

/**
 * 
 */
public interface Live {

    /**
     * set the current amount of lives to be displayed on screen.
     * @param lifeCounter
    */
    void setLivesImage(int lifeCounter);

    /**
     * draw the current amount of lives on screen.
     */
    void drawLives();

}
