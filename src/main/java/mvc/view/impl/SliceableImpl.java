package mvc.view.impl;

import mvc.view.Sliceable;

import javax.swing.*;
import java.awt.geom.Point2D;

public class SliceableImpl extends JLabel implements Sliceable {

     public ImageIcon sliceableImage;
    /**
     * Refers to the top-left corner of the Image
     */
    Point2D position;
    boolean isVisible;

    @Override
    public boolean isVisible(boolean isSliced) {
        isVisible = !isSliced;
        return !isSliced;
    }

    // TODO
    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public void setSliaceablePosition(Point2D position) {
        double xPosition = position.getX();
        double yPosition = position.getY();

        this.setLocation((int)xPosition, (int)yPosition);
    }

    @Override
    public void setSliceStatus() {
        isVisible = !isVisible;
    }
}
