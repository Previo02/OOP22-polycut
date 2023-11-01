package mvc.view.impl;

import java.io.Serial;

import javax.swing.ImageIcon;

import mvc.model.SliceableTypeEnum;
import mvc.view.SliceableView;

/**
 * SliceableView interface implementation.
 * Read the relative javadoc for the documentation.
 */
public class SliceableViewImpl implements SliceableView {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final String TRIANGLE_PATH = "src/main/java/mvc/view/GraphicElements/triangle.png";
    private static final String SQUARE_PATH = "src/main/java/mvc/view/GraphicElements/square.png";
    private static final String PENTAGON_PATH = "src/main/java/mvc/view/GraphicElements/pentagon.png";
    private static final String HEXAGON_PATH = "src/main/java/mvc/view/GraphicElements/hexagon.png";
    private static final String BOMB_PATH = "src/main/java/mvc/view/GraphicElements/bomb.png";

    private static final int HEXAGON_HEIGHT = 113;
    private static final int PENTAGON_HEIGHT = 97;
    private static final int SQUARE_HEIGHT = 98;
    private static final int TRIANGLE_HEIGHT = 88;
    private static final int BOMB_HEIGHT = 98;

    // private boolean isVisible;
    // private Point2D position;

    /**
     * {@inheritDoc}
     */
    @Override
    public ImageIcon getImage(final SliceableTypeEnum sliceableType) {
        switch (sliceableType) {
            case TRIANGLE:
                return new ImageIcon(TRIANGLE_PATH);
            case SQUARE:
                return new ImageIcon(SQUARE_PATH);
            case PENTAGON:
                return new ImageIcon(PENTAGON_PATH);
            case HEXAGON:
                return new ImageIcon(HEXAGON_PATH);
            case BOMB:
                return new ImageIcon(BOMB_PATH);
            default:
                return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSliceableHeight(final SliceableTypeEnum sliceableType) {
        switch (sliceableType) {
            case TRIANGLE:
                return TRIANGLE_HEIGHT;
            case SQUARE:
                return SQUARE_HEIGHT;
            case PENTAGON:
                return PENTAGON_HEIGHT;
            case HEXAGON:
                return HEXAGON_HEIGHT;
            case BOMB :
                return BOMB_HEIGHT;
            default:
                return -1;
        }
    }
}
