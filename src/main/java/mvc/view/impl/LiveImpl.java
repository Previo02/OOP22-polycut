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
    //TODO cambia dimensione label delle vite
    private static String heartPath = "src/main/java/mvc/view/GraphicElements/3hearts.png";
    private Integer livesCounter = 3;

    /**
     * Constructor sets the image of 3 lives.
     */
    public LiveImpl() {
        final ImageIcon livesImage = new ImageIcon(heartPath);
        this.setIcon(livesImage);
    }

    /**
     * Sets the correct image based on the number of lives.
     * @param livesCounter current lives
     */
    private static void setCorrectPath(final Integer livesCounter) {
        switch (livesCounter) {
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
     * Draw the currents lives.
     */
    private void drawLives() {
        System.out.println("drawing lives...");
        setCorrectPath(this.livesCounter);
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
     *{@inheritDoc}.
     */
    @Override
    public void decreaseLives() {
        livesCounter = livesCounter - 1;
        drawLives();
    }
}
