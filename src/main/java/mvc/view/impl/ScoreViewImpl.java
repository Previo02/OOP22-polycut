package mvc.view.impl;

import mvc.view.ScoreView;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.awt.FontFormatException;

/**
 * Score class. Count the score of the game.
 */
public class ScoreViewImpl extends JLabel implements ScoreView {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final int FONT_SIZE = 35;
    private Integer currentScore = 0;

    /**
     * Constructor sets up the font and the default score of 0.
     */
    public ScoreViewImpl() {
        final Font scoreFont;
        this.setText("Score: " + this.currentScore);
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
    public Integer getScore() {
        return currentScore;
    }

    /**
     * Score setter.
     * @param score To set in the label
     */
    @Override
    public void setScore(final Integer score) {
        this.currentScore = score;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void printScore() {
        setText("Score: " + currentScore);
    }
}
