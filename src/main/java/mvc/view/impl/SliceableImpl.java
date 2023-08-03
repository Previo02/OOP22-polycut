package mvc.view.impl;

import mvc.view.Sliceable;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.geom.Point2D;

public class SliceableImpl extends JLabel implements Sliceable {//

    private static final String TRIANGLE_PATH = "src/main/java/mvc/view/GraphicElements/triangle.png";
    private static final String SQUARE_PATH = "src/main/java/mvc/view/GraphicElements/square.png";
    private static final String PENTAGON_PATH = "src/main/java/mvc/view/GraphicElements/pentagon.png";
    private static final String HEXAGON_PATH = "src/main/java/mvc/view/GraphicElements/hexagon.png";
    /**
     * Refers to the top-left corner of the Image
     */
    Point2D position;
    boolean isVisible;
    final private PolygonEnum polygonType;
    public SliceableImpl(Point2D position, PolygonEnum polygonType ){
        this.polygonType = polygonType;
        this.position = position;
    }

    @Override
    public void changeVisibility(boolean isSliced) {
        isVisible = !isSliced;
    }

    @Override
    public boolean isVisible(){
        return isVisible;
    }

    // TODO
    @Override
    public Point2D getPosition() {
        return position;
    }

    @Override
    public void setSliaceablePosition(Point2D position) {
        double xPosition = position.getX();
        double yPosition = position.getY();

        this.setLocation((int)xPosition, (int)yPosition);
    }

    public Image getImage (PolygonEnum polygonType){
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
        }
        return null;
    }

    @Override
    public void setSliceStatus() {
        isVisible = !isVisible;
    }

    public void drawPolygon(Graphics graphics){

        int xPosition = (int) position.getX();
        int yPosition = (int) position.getY();
        Image image = getImage(this.polygonType);
        graphics.drawImage(image, xPosition, yPosition, this);

    }
}
