package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class GameScreen {//

    // TODO summary
    public void createAndShowGui() {

        JFrame frame = new JFrame("Polygon Cutter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

        // BG
        frame.setContentPane(new JLabel(new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg")));

        // Frame Layout
        frame.setLayout(new BorderLayout());

        // setting-up Lives and Score
        var upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setOpaque(false);
        frame.add(upperPanel, BorderLayout.NORTH);

        // Lives on the left
        var livesLabel = new LiveImpl();
        upperPanel.add(livesLabel, BorderLayout.WEST);

        // Score on the right
        var scoreLabel = new ScoreImpl();
        upperPanel.add(scoreLabel, BorderLayout.EAST);
        scoreLabel.printScore();

        //adding GameArea
        var middleArea = new GameArea();
        frame.add(middleArea, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
