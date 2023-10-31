package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

/**
 * GameScreen class, it represents the PlayButton generated GUI.
 */
public class GameScreen {
    public final ScoreViewImpl score = new ScoreViewImpl();
    public final LiveImpl lives = new LiveImpl();

    /**
     * Prepare the frame that contains all the game's elements.
     * @return GameArea
     */
    public GameArea createAndShowGui() {

        // Configuration of the Frame Behavior
        final JFrame frame = new JFrame("Polygon Cutter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

        /*Background*/
        frame.setContentPane(new JLabel(new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg")));

        // Setting the main Layout of the Frame
        frame.setLayout(new BorderLayout());

        // Setting-up Lives and Score
        final var upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setOpaque(false);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lives on the left
        upperPanel.add(lives, BorderLayout.WEST);

        // Score on the right
        upperPanel.add(score, BorderLayout.EAST);
        score.printScore();

        //Adding the GameArea where Sliceable will be drawn
        final var middleArea = new GameArea();
        frame.add(middleArea, BorderLayout.CENTER);
        middleArea.setOpaque(false);

        frame.setVisible(true);
        return middleArea;
    }
}
