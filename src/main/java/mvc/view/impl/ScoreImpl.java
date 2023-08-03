package mvc.view.impl;

import mvc.view.Score;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScoreImpl extends JLabel implements Score {

    int currentScore = 0;
    Font scoreFont;

    public ScoreImpl(){
        this.setText("Score: " + currentScore); // Imposta direttamente il testo in questa istanza di JLabel
        try {
            scoreFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/mvc/view/GraphicElements/Orbitron/Orbitron-VariableFont_wght.ttf")).deriveFont(Font.PLAIN, 35);
            this.setFont(scoreFont); // Imposta il font in questa istanza di JLabel
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printScore() {
        setText("Score: " + currentScore); // Imposta il testo nella stessa istanza di JLabel
    }
}
