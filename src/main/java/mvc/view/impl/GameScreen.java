package mvc.view.impl;

import mvc.view.impl.LiveImpl;
import mvc.view.impl.ScoreImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameScreen {//

    // TODO summary
    public void createAndShowGui() {

        JFrame frame = new JFrame("Polygon Cutter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

//        // BG
        frame.setContentPane(new JLabel(new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg")));
//        try {
//            Image backgroundImage = ImageIO.read(new File("src/main/java/mvc/view/GraphicElements/Background.jpg"));
//            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
//            frame.setContentPane(backgroundLabel);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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

        frame.setVisible(true);
    }
}
