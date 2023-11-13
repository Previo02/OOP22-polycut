package mvc.view.impl;

import mvc.view.GameScreen;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

/**
 * GameScreen class, it represents the PlayButton generated GUI.
 */
public class GameScreenImpl implements GameScreen {
    private final LiveImpl livesLabel = new LiveImpl();
    private final ScoreViewImpl scoreLabel = new ScoreViewImpl();
    private final JFrame frame;

    /**
     * GameScreen constructor.
     */
    public GameScreenImpl() {
        frame = new JFrame("Polygon Cutter");
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
     * {@inheritDoc}
     */
    @Override
    public LiveImpl getCurrentLives() {
        return this.livesLabel.getCurrLiveImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScoreValue() {
        return this.scoreLabel.getScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOverPanel() {
        JOptionPane.showMessageDialog(
                this.frame, "Game Over!\nPunteggio: " + this.scoreLabel.getScore()
                + "\nRecord: " + this.getCurrentBestScore());
        this.frame.dispose();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setNewBestScore(final int record) {

        if (record < scoreLabel.getScore()) {
            try {
                final BufferedWriter recordWriter = new BufferedWriter(new FileWriter("record.txt"));
                recordWriter.write(Integer.toString(scoreLabel.getScore()));
                recordWriter.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentBestScore() {
        try {
            final BufferedReader recordReader = new BufferedReader(new FileReader("record.txt"));
            return Integer.parseInt(recordReader.readLine());
        } catch (IOException e) {
            return 0;
        }
    }
}
