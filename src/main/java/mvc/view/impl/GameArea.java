package mvc.view.impl;

import javax.swing.JPanel;
import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import java.io.Serial;

/**
 * GameArea class, it represents the playable area.
 */
public class GameArea extends JPanel {
    private final List<Polygon> polygons;
    private final List<Bomb> bombs;

    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     */
    public GameArea() {
        polygons = new ArrayList<>();
        bombs = new ArrayList<>();
    }

    /**
     * Add a new Polygon to the list of polygons in GameArea.
     * @param drawPoint Where the polygon will be drawn.
     * @param polygonType The Type of polygon to draw.
     */
    public void addPolygon(final Point2D drawPoint, final PolygonEnum polygonType) {
        final Polygon polygon = new Polygon(drawPoint, polygonType);
        polygon.setSliceablePosition(drawPoint);
        polygons.add(polygon);
    }

    /**
     * Add a new Bomb to the list of bombs in GameArea.
     * @param drawPoint Where the bomb will be drawn.
     */
    public void addBomb(final Point2D drawPoint) {
        final Bomb bomb = new Bomb(drawPoint);
        bomb.setSliceablePosition(drawPoint);
        bombs.add(bomb);
    }

    /**
     * {@inheritDoc}.
     * Paints every Sliceable in the logically present in the GameArea.
     * @param g the <code>Graphics</code> object to protect.
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        for (final Polygon polygon : polygons) {
            polygon.drawPolygon(g);
        }

        for (final Bomb bomb : bombs) {
            bomb.drawBomb(g);
        }
    }
}
