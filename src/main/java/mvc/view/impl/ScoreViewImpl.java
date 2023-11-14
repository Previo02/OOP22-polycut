package mvc.view.impl;

import mvc.view.ScoreView;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.awt.FontFormatException;
import java.io.InputStream;

/**
 * Score class. Count the score of the game.
 */
public final class ScoreViewImpl extends JLabel implements ScoreView {
    private static final double serialVersionUID = 0L;
    private static final int FONT_SIZE = 35;
    private int currentScore;

    /**
     * Constructor sets up the font and the default score of 0.
     */
    public ScoreViewImpl() {
        final Font scoreFont;
        this.currentScore = 0;
        this.setText("Score: " + currentScore);

        try (InputStream fontInputStream =
                     getClass().getResourceAsStream("/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf")) {
            if (fontInputStream == null) {
                throw new IllegalStateException("Font file not found.");
            }

            scoreFont = Font.createFont(Font.TRUETYPE_FONT, fontInputStream).deriveFont(Font.PLAIN, FONT_SIZE);
            this.setFont(scoreFont);
        } catch (FontFormatException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Score getter.
     * @return current score.
     */
    @Override
    public int getScore() {
        return currentScore;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void increaseScore() {
        currentScore = currentScore + 1;
        this.drawScore();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void drawScore() {
        this.setText("Score: " + currentScore);
    }
}
