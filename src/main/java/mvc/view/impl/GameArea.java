package mvc.view.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GameArea extends JPanel {
    final private SliceableImpl square;

    public GameArea(){
        Point2D point = new Point2D.Double(0, 0);

        square = new SliceableImpl(point, PolygonEnum.HEXAGON);
        square.setSliaceablePosition(point);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //TEST
        // Draw background
//        ImageIcon backgroundImage = new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg");
//        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

        square.drawPolygon(g);
    }
}
