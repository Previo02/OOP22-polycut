package mvc.view.impl;

import javax.swing.*;

import mvc.view.SliceableView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
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
        this.setLayout(null);
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
    public void addPolygonsOnScreen(List<Polygon> polygons){
        for (Polygon polygon: polygons) {
            JLabel newSliceable = new JLabel(new ImageIcon(polygon.getImage(polygon.getPolygonType())));
            newSliceable.setBounds((int)polygon.getPosition().getX(),(int)polygon.getPosition().getY(),Polygon.POLYGON_WIDTH,polygon.getPolygonDimension(polygon.getPolygonType()));
            this.add(newSliceable);
            newSliceable.addMouseListener(new MouseAdapter() {
                     @Override
                     public void mouseEntered(MouseEvent e) {
                         polygon.setSliceStatus();
                     }
                 }
            );
        }
    }
    public void addBombsOnScreen(List<Bomb> bombs){
        for (Bomb bomb : bombs) {
            JLabel newSliceable = new JLabel(new ImageIcon(Bomb.BOMB_PATH));
            newSliceable.setBounds((int)bomb.getPosition().getX(),(int)bomb.getPosition().getY(),Bomb.BOMB_WIDTH,Bomb.BOMB_HEIGHT);
            this.add(newSliceable);
            newSliceable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    bomb.setSliceStatus();
                }
          });
        }
    }

    public void sliceableToRemove(){

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
//    @Override
//    protected void paintComponent(final Graphics g) {
//        super.paintComponent(g);
//
//        for (final Polygon polygon : polygons) {
//            polygon.drawPolygon(g);
//        }
//
//        for (final Bomb bomb : bombs) {
//            bomb.drawBomb(g);
//        }
//    }
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
