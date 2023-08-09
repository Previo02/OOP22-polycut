package mvc.view.impl;

import javax.swing.JPanel;

import mvc.view.SliceableView;

import java.awt.geom.Point2D;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.io.Serial;

/**
 * GameArea class, it represents the playable area.
 */
public class GameArea extends JPanel {
    @Serial
    private static final long serialVersionUID = 0L;
    private final List<Polygon> polygons;
    private final List<Bomb> bombs;
    private final LiveImpl lives;

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     */
    public GameArea() {
        this.polygons = new ArrayList<>();
        this.bombs = new ArrayList<>();
        this.lives = new LiveImpl();
    }

    /**
     * Add a new Polygon to the list of polygons in GameArea.
     * @param drawPoint Where the polygon will be drawn.
     * @param polygonType The Type of polygon to draw.
     * @param polygonId the polygon identifier.
     */
    public void addPolygon(final Point2D drawPoint, final PolygonEnum polygonType, final int polygonId) {
        final Polygon polygon = new Polygon(drawPoint, polygonType, polygonId);
        polygon.setSliceablePosition(drawPoint);
        polygons.add(polygon);
    }

    /**
     * Add a new Bomb to the list of bombs in GameArea.
     * @param drawPoint Where the bomb will be drawn.
     * @param bombId the bomb identifier.
     */
    public void addBomb(final Point2D drawPoint, final int bombId) {
        final Bomb bomb = new Bomb(drawPoint, bombId);
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
    /**
     * Getter.
     * @return List<Polygon> list
     */
    public List<Polygon> getPolygons() {
        return new ArrayList<>(this.polygons);
    }
    /**
     * Getter.
     * @return List<Polygon> list
     */
    public List<Bomb> getBombs() {
        return new ArrayList<>(this.bombs);
    }

    /**
     * Getter for livesCounter.
     * @return The number of remaining lives.
     */
    public Integer getLivesCounter() {
        return lives.getLivesCounter();
    }

    /**
     * Setter for livesCounter.
     * @param livesCounter Number of lives to set.
     */
    public void setLivesCounter(final Integer livesCounter) {
        this.lives.setLivesCounter(livesCounter);
    }

    public List<SliceableView> getSliceables() {
        List<SliceableView> sliceableList = new ArrayList<>(getPolygons());
        sliceableList.addAll(getBombs());
        return sliceableList;
    }

}
