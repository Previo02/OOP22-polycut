package mvc.view.impl;

import java.io.Serial;
import javax.swing.*;
import java.nio.file.FileSystemNotFoundException;

public class LiveImpl extends JLabel implements mvc.view.Live {
    @Serial
    private static final long serialVersionUID = 0L;
    private String heartPath = "src/main/java/mvc/view/GraphicElements/3hearts.png";
    private int livesCounter;


    /**
     * Constructor sets the image of 3 lives
     */
    public LiveImpl() {
        ImageIcon livesImage = new ImageIcon(heartPath);
        setIcon(livesImage);
    }

    /**
     * {@inheritDoc}
     * @param lifeCounter
     */
    @Override
    public void getCorrectPath(final int lifeCounter) {
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
        drawLives();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawLives() {
        setIcon(new ImageIcon(heartPath));
        revalidate();
        repaint();
    }

    /**
     * Getter for livesCounter
     * @return The number of remaining lives
     */
    public int getLivesCounter() {
        return livesCounter;
    }

    /**
     * Setter for livesCounter
     * @param livesCounter Number of lives to set
     */
    public void setLivesCounter(int livesCounter) {
        this.livesCounter = livesCounter;
    }
}
