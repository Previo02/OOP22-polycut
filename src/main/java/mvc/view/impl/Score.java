package mvc.view.impl;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Score extends JLabel implements mvc.view.Score {

    int currentScore = 0;
    Font scoreFont;

    /**
     * Constructor sets up the font and the default score of 0
     */
    public Score(){
        this.setText("Score: " + currentScore); // Imposta direttamente il testo in questa istanza di JLabel
        try {
            scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/mvc/view/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf")).deriveFont(Font.PLAIN, 35);
            this.setFont(scoreFont);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printScore() {
        setText("Score: " + currentScore);
    }
}
