package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mvc.view.GameArea;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameScreen class, it represents the PlayButton generated GUI.
 */
public class GameScreen {
    private final ScoreViewImpl score = new ScoreViewImpl();
    private final LiveImpl lives = new LiveImpl();

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
        upperPanel.add(lives, BorderLayout.WEST);

        // Score on the right
        upperPanel.add(score, BorderLayout.EAST);
        score.printScore();

        //Adding the GameArea where Sliceable will be drawn
        final var middleArea = new GameAreaImpl();
        frame.add(middleArea, BorderLayout.CENTER);
        middleArea.setOpaque(false);

//        // Testing
//        middleArea.addPolygon(new Point2D.Double(500,500), SliceableEnum.HEXAGON, 0);
//        middleArea.addPolygon(new Point2D.Double(666,666), SliceableEnum.SQUARE, 0);
//        middleArea.addBomb(new Point2D.Double(100,500), 0);
//        var lables = middleArea.addPolygonsOnScreen(middleArea.getPolygons());
//        middleArea.addBombsOnScreen(middleArea.getBombs());
//        for (var label: lables) {
//            middleArea.remove(label);
//        }
//        middleArea.revalidate();
//
//        var polyList = middleArea.getPolygons();
//        for (var poly : polyList) {
//            poly.setPosition(new Point2D.Double(new Random().nextInt(900),new Random().nextInt(900)));
//        }
//        lables = middleArea.addPolygonsOnScreen(middleArea.getPolygons());

        frame.setVisible(true);
        return middleArea;
    }
}
