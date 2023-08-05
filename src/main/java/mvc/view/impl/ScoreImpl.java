package mvc.view.impl;

import mvc.view.Score;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

import javax.swing.JLabel;

/**
 * 
 */
public class ScoreImpl extends JLabel implements Score {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final int FONT_SIZE = 35;

    private int currentScore;

    public ScoreImpl() {
        final Font scoreFont;

        this.setText("Score: " + currentScore); // Imposta direttamente il testo in questa istanza di JLabel
        try {
            scoreFont = Font.createFont(Font.TRUETYPE_FONT,
                            new File("src/main/java/mvc/view/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf"))
                                    .deriveFont(Font.PLAIN, FONT_SIZE);
            this.setFont(scoreFont); // Imposta il font in questa istanza di JLabel
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printScore() {
        setText("Score: " + currentScore); // Imposta il testo nella stessa istanza di JLabel
    }
}
