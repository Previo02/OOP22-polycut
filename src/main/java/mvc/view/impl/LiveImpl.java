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
    private String heartPath;
    private Integer livesCounter = 3;

    /**
     * Constructor sets the image of 3 lives.
     */
    public LiveImpl() {
        heartPath = "/GraphicElements/3hearts.png";
        final ImageIcon livesImage = new ImageIcon(LiveImpl.class.getResource(heartPath));
        this.setIcon(livesImage);
    }

    /**
     * Sets the correct image based on the number of lives.
     * @param livesCounter current lives
     */
    private void setCorrectPath(final Integer livesCounter) {
        switch (livesCounter) {
            case 0:
                heartPath = "";
                break;
            case 1:
                heartPath = "/GraphicElements/heart.png";
                break;
            case 2:
                heartPath = "/GraphicElements/2hearts.png";
                break;
            case 3:
                heartPath = "/GraphicElements/3hearts.png";
                break;
            default:
                throw new FileSystemNotFoundException();
        }
    }

    /**
     * Draw the currents lives.
     */
    private void drawLives() {
        setCorrectPath(this.livesCounter);
        this.setIcon(new ImageIcon(LiveImpl.class.getResource(heartPath)));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public LiveImpl getCurrLiveImpl() {
        return this;
    }
}
