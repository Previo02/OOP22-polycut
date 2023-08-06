package mvc.view.impl;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.awt.FontFormatException;

public class Score extends JLabel implements mvc.view.Score {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final int FONT_SIZE = 35;

    Font scoreFont;
    private int currentScore = 0;

    /**
     * Constructor sets up the font and the default score of 0
     */
    public Score(){
        this.setText("Score: " + currentScore);
        try {
            scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/mvc/view/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf"))
                    .deriveFont(Font.PLAIN, FONT_SIZE);
            this.setFont(scoreFont);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getScore() {
        return currentScore;
    }

    @Override
    public void setScore(int score) {
        this.currentScore = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printScore() {
        setText("Score: " + currentScore);
    }
}
