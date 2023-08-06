package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.geom.Point2D;

public class GameScreen {//

    /**
     * Prepare the frame that contains all the game's elements
     */
    public void createAndShowGui() {

        // Configuration of the Frame Behavior
        final JFrame frame = new JFrame("Polygon Cutter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

        try {
            // setting the background
            frame.setContentPane(new JLabel(new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg")));
        }catch (Exception e){
            System.out.print("Impossible to set background!\n Image not found");
        }

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
        final var scoreLabel = new Score();
        upperPanel.add(scoreLabel, BorderLayout.EAST);
        scoreLabel.printScore();

        //Adding the GameArea where Sliceable will be drawn
        final var middleArea = new GameArea();
        frame.add(middleArea, BorderLayout.CENTER);
        middleArea.setOpaque(false);

        // Some tests
        middleArea.addPolygon(new Point2D.Double(0, 0), PolygonEnum.TRIANGLE);
        middleArea.addPolygon(new Point2D.Double(222, 93), PolygonEnum.SQUARE);
        middleArea.addPolygon(new Point2D.Double(500, 500), PolygonEnum.HEXAGON);
        middleArea.addPolygon(new Point2D.Double(111, 72), PolygonEnum.PENTAGON);

        middleArea.addBomb(new Point2D.Double(251, 287));


        frame.setVisible(true);
    }
}
