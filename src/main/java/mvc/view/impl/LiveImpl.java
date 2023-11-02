package mvc.view.impl;

import mvc.view.Live;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.nio.file.FileSystemNotFoundException;

/**
 * Lives Implementation.
 */
public class LiveImpl extends JLabel implements Live {

    private static final double serialVersionUID = 0L;
    private String heartPath = "src/main/java/mvc/view/GraphicElements/3hearts.png";
    private Integer livesCounter;

    /**
     * Constructor sets the image of 3 lives.
     */
    public LiveImpl() {
        final ImageIcon livesImage = new ImageIcon(heartPath);
        this.setIcon(livesImage);
        this.setLivesCounter(3);
        // drawLives();
    }

    /**
     * Sets the correct image based on the number of lives.
     * @param lifeCounter the number of lives.
     */
    private void setCorrectPath(final int lifeCounter) {
        switch (lifeCounter) {
            case 0:
                heartPath = "";
                break;
            case 1:
                heartPath = "src/main/java/mvc/view/GraphicElements/heart.png";
                break;
            case 2:
                heartPath = "src/main/java/mvc/view/GraphicElements/2hearts.png";
                break;
            case 3:
                heartPath = "src/main/java/mvc/view/GraphicElements/3hearts.png";
                break;
            default:
                throw new FileSystemNotFoundException();
        }
    }

    /**
     * Draws the correct amount of lives on screen.
     */
    private void drawLives() {
        this.setCorrectPath(this.livesCounter);
        this.setIcon(new ImageIcon(heartPath));
        revalidate();
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLivesCounter() {
        return livesCounter;
    }

    /**
     * Setter for livesCounter.
     * @param setLives Number of lives to set.
     */
    private void setLivesCounter(final int setLives) {
        this.livesCounter = setLives;
        this.drawLives();
    }
}
