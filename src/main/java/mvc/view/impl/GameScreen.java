package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameScreen class, it represents the PlayButton generated GUI.
 */
public class GameScreen {

    /**
     * Prepare the frame that contains all the game's elements.
     * @return GameArea
     */
    public GameAreaImpl createAndShowGui() {

        // Configuration of the Frame Behavior
        final JFrame frame = new JFrame("Polygon Cutter");
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
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {

            }
        });

        /*Background*/
        frame.setContentPane(new JLabel(new ImageIcon("src\\main\\java\\mvc\\view\\GraphicElements\\background.jpg")));

        // Setting the main Layout of the Frame
        frame.setLayout(new BorderLayout());

        // Setting-up Lives and Score
        final var upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setOpaque(false);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lives on the left
        final var livesLabel = new LiveImpl();
        upperPanel.add(livesLabel, BorderLayout.WEST);

        // Score on the right
        final var scoreLabel = new ScoreViewImpl();
        upperPanel.add(scoreLabel, BorderLayout.EAST);
        scoreLabel.printScore();

        //Adding the GameArea where Sliceable will be drawn
        final var middleArea = new GameAreaImpl();
        frame.add(middleArea, BorderLayout.CENTER);
        middleArea.setOpaque(false);

        frame.setVisible(true);
        return middleArea;
    }
}
