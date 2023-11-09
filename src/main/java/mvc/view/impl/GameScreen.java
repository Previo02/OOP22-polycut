package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameScreen class, it represents the PlayButton generated GUI.
 */
public class GameScreen {
    private final LiveImpl livesLabel = new LiveImpl();
    private final ScoreViewImpl scoreLabel = new ScoreViewImpl();
    private final JFrame frame;

    /**
     * GameScreen constructor.
     */
    public GameScreen() {
        frame = new JFrame("Polygon Cutter");
    }

    /**
     * Prepare the frame that contains all the game's elements.
     * @return GameArea
     */
    public GameAreaImpl createAndShowGui() {
        // Configuration of the Frame Behavior
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);

        // Adding control to close the frame
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {

            }

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                    Runtime.getRuntime().exit(0);
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {

            }
        });

        //Background
        frame.setContentPane(new JLabel(new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg")));

        // Setting the main Layout of the Frame
        frame.setLayout(new BorderLayout());

        // Setting-up Lives and Score
        final var upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setOpaque(false);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lives on the left
        upperPanel.add(livesLabel, BorderLayout.WEST);

        // Score on the right
        upperPanel.add(scoreLabel, BorderLayout.EAST);

        //Adding the GameArea where Sliceable will be drawn
        final var middleArea = new GameAreaImpl(this.livesLabel, this.scoreLabel);
        frame.add(middleArea, BorderLayout.CENTER);
        middleArea.setOpaque(false);

        frame.setVisible(true);
        return middleArea;
    }

    /**
     * @return the istance of the lives label.
     */
    public LiveImpl getCurrentLives() {
        return this.livesLabel.getCurrLiveImpl();
    }

    /**
     * @return the score
     */
    public int getScoreValue() {
        return this.scoreLabel.getScore();
    }

    /**
     * {@inheritDoc}
     */
    public void gameOverPanel() {
        JOptionPane.showMessageDialog(this.frame, "Game Over!\nPunteggio: " + this.scoreLabel.getScore());
        this.frame.dispose();
    }
}
