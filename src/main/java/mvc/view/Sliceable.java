package mvc.view;

import java.awt.geom.Point2D;

public interface Sliceable {

    // Utilizzare GetBorder per parte controller

    void changeVisibility(boolean isSliced);

    boolean isVisible();

    //the center of the image
    Point2D getPosition();

    void setSliaceablePosition(Point2D position);

    void setSliceStatus();
}
