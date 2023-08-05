package mvc.view.impl;

import mvc.view.SliceableView;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serial;

/**
 * 
 */
public class SliceableViewImpl extends JLabel implements SliceableView {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final String TRIANGLE_PATH = "src/main/java/mvc/view/GraphicElements/triangle.png";
    private static final String SQUARE_PATH = "src/main/java/mvc/view/GraphicElements/square.png";
    private static final String PENTAGON_PATH = "src/main/java/mvc/view/GraphicElements/pentagon.png";
    private static final String HEXAGON_PATH = "src/main/java/mvc/view/GraphicElements/hexagon.png";
    private static final int POLYGON_WIDTH = 100;
    private static final int POLYGON_HEIGHT = 100;

    /**
     * Refers to the top-left corner of the Image
     */
    private final Point2D position;
    private boolean isVisible;
    final private PolygonEnum polygonType;

    /**
     * 
     * @param position
     * @param polygonType
     */
    public SliceableViewImpl(final Point2D position, final PolygonEnum polygonType) {
        this.polygonType = polygonType;
        this.position = position;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public void changeVisibility(final boolean isSliced) {
        isVisible = !isSliced;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public Point2D getPosition() {
        return position;
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public void setSliaceablePosition(final Point2D position) {
        final double xPosition = position.getX();
        final double yPosition = position.getY();

        this.setLocation((int) xPosition, (int) yPosition);
    }

    public Image getImage (final PolygonEnum polygonType) {
        switch (polygonType) {
            case TRIANGLE -> {
                return new ImageIcon(TRIANGLE_PATH).getImage();
            }
            case SQUARE -> {
                return new ImageIcon(SQUARE_PATH).getImage();
            }
            case PENTAGON -> {
                return new ImageIcon(PENTAGON_PATH).getImage();
            }
            case HEXAGON -> {
                return new ImageIcon(HEXAGON_PATH).getImage();
            }
            default -> { return null; }
        }
    }

    /**
     * {@inheritdoc}.
     */
    @Override
    public void setSliceStatus() {
        isVisible = !isVisible;
    }

    public void drawPolygon(final Graphics graphics) {

        final int xPosition = (int) position.getX();
        final int yPosition = (int) position.getY();
        final Image image = getImage(this.polygonType);
        // per modificare la dimensione dell'immagine
        graphics.drawImage(image, xPosition, yPosition, POLYGON_WIDTH, POLYGON_HEIGHT, this);

    }

    /**
     * {@inheritdoc}.
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        //TEST
        // Draw background
       final ImageIcon backgroundImage = new ImageIcon("src/main/java/mvc/view/GraphicElements/background.jpg");
       g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

       drawPolygon(g);
    }

}
