package mvc.view.impl;

import mvc.view.ScoreView;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

/**
 * Score class. Count the score of the game.
 */
public class ScoreViewImpl extends JLabel implements ScoreView {
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
        try {
            scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File(
                            "src/main/java/mvc/view/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf"))
                    .deriveFont(Font.PLAIN, FONT_SIZE);
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
