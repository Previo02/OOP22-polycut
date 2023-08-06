package mvc.view.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameArea extends JPanel {
    final private List<Polygon> polygons;
    final private List<Bomb> bombs;

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea
     */
    public GameArea() {
        polygons = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    /**
     * Add a new Polygon to the list of polygons in GameArea
     * @param drawPoint Where the polygon will be drawn
     * @param polygonType The Type of polygon to draw
     */
    public void addPolygon(Point2D drawPoint, PolygonEnum polygonType) {
        Polygon polygon = new Polygon(drawPoint, polygonType);
        polygon.setSliaceablePosition(drawPoint);
        polygons.add(polygon);
    }

    /**
     * Add a new Bomb to the list of bombs in GameArea
     * @param drawPoint Where the bomb will be drawn
     */
    public void addBomb(Point2D drawPoint) {
        Bomb bomb = new Bomb(drawPoint);
        bomb.setSliaceablePosition(drawPoint);
        bombs.add(bomb);
    }

    /**
     * {@inheritDoc}
     * Paints every Sliceable in the logically present in the GameArea
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Polygon polygon : polygons) {
            polygon.drawPolygon(g);
        }

        for (Bomb bomb : bombs) {
            bomb.drawBomb(g);
        }
    }
}
