package mvc.view.impl;

import mvc.view.Live;

import javax.swing.*;

public class LiveImpl extends JLabel implements Live {
    private String heartPath = "src/main/java/mvc/view/GraphicElements/2hearts.png";
    private ImageIcon livesImage = new ImageIcon(heartPath);

    public LiveImpl() {
        setIcon(livesImage);
    }

    @Override
    public void getCorrectPath(int lifeCounter) {
        switch (lifeCounter) {
            case 0: {
                heartPath = "";
                break;
            }
            case 1: {
                heartPath = "src/main/java/mvc/view/GraphicElements/heart.png";
                break;
            }
            case 2: {
                heartPath = "src/main/java/mvc/view/GraphicElements/2hearts.png";
                break;
            }
            case 3: {
                heartPath = "src/main/java/mvc/view/GraphicElements/3hearts.png";
                break;
            }
            default: {
                // TODO gestire eccezione
            }
        }
        drawLives();
    }

    @Override
    public void drawLives() {
        setIcon(new ImageIcon(heartPath)); // Imposta la nuova immagine dell'ImageIcon
        revalidate(); // Ricarica il layout del pannello
        repaint();
    }
}
