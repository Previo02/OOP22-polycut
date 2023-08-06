package mvc.view.impl;

import mvc.view.Sliceable;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Point2D;

public class Polygon extends JLabel implements Sliceable {

    private static final String TRIANGLE_PATH = "src/main/java/mvc/view/GraphicElements/triangle.png";
    private static final String SQUARE_PATH = "src/main/java/mvc/view/GraphicElements/square.png";
    private static final String PENTAGON_PATH = "src/main/java/mvc/view/GraphicElements/pentagon.png";
    private static final String HEXAGON_PATH = "src/main/java/mvc/view/GraphicElements/hexagon.png";
    Point2D position;
    boolean isVisible;
    final private PolygonEnum polygonType;

    /**
     * Constructor create a Polygon with the provided params
     * @param position The position of the top-left corner of the polygon's image
     * @param polygonType The type of polygon
     */
    public Polygon(Point2D position, PolygonEnum polygonType ){
        this.polygonType = polygonType;
        this.position = position;
    }

    /**
     * {@inheritDoc}
     * @param isSliced
     */
    @Override
    public void changeVisibility(boolean isSliced) {
        isVisible = !isSliced;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public boolean isVisible(){
        return isVisible;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Point2D getPosition() {
        return position;
    }

    /**
     * {@inheritDoc}
     * @param position top-left corner
     */
    @Override
    public void setSliaceablePosition(Point2D position) {
        double xPosition = position.getX();
        double yPosition = position.getY();

        this.setLocation((int)xPosition, (int)yPosition);
    }

    /**
     * Get the correct image for the requested polygon type
     * @param polygonType The type of polygon of witch to get the image
     * @return The Image of the Polygon
     */
    public Image getImage (PolygonEnum polygonType){
        switch (polygonType) {
            case TRIANGLE : {
                return new ImageIcon(TRIANGLE_PATH).getImage();
            }
            case SQUARE : {
                return new ImageIcon(SQUARE_PATH).getImage();
            }
            case PENTAGON : {
                return new ImageIcon(PENTAGON_PATH).getImage();
            }
            case HEXAGON : {
                return new ImageIcon(HEXAGON_PATH).getImage();
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSliceStatus() {
        isVisible = !isVisible;
    }

    /**
     * Draw the Polygon in GameArea in the specified position
     * @param graphics The Graphics object used for drawing
     */
    public void drawPolygon(Graphics graphics){

        int xPosition = (int) position.getX();
        int yPosition = (int) position.getY();
        Image image = getImage(this.polygonType);
        graphics.drawImage(image, xPosition, yPosition, this);

    }
}
