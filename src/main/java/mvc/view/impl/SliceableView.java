package mvc.view.impl;

import javax.swing.ImageIcon;

import mvc.model.SliceableTypeEnum;

/**
 * Utility class for the correct visualization of Sliceables.
 */
public final class SliceableView {
    private static final String GRAPHIC_ELEMENTS_PATH = "/GraphicElements/";
    private static final String TRIANGLE_PATH = "triangle.png";
    private static final String SQUARE_PATH = "square.png";
    private static final String PENTAGON_PATH = "pentagon.png";
    private static final String HEXAGON_PATH = "hexagon.png";
    private static final String BOMB_PATH = "bomb.png";

    /**
     * Public width, same for every sliceable.
     */
    public static final int SLICEABLE_WIDTH = 100;
    private static final int HEXAGON_HEIGHT = 113;
    private static final int PENTAGON_HEIGHT = 97;
    private static final int SQUARE_HEIGHT = 98;
    private static final int TRIANGLE_HEIGHT = 88;
    private static final int BOMB_HEIGHT = 98;

    private SliceableView() { }

    /**
     * Getting the ImageIcon.
     * @param sliceableType number of sides
     * @return the ImageIcon associated with the polygon
     */
    public static ImageIcon getImage(final SliceableTypeEnum sliceableType) {
        final StringBuilder imagePathBuilder = new StringBuilder(GRAPHIC_ELEMENTS_PATH);
        switch (sliceableType) {
            case TRIANGLE:
                imagePathBuilder.append(TRIANGLE_PATH);
                break;
            case SQUARE:
                imagePathBuilder.append(SQUARE_PATH);
                break;
            case PENTAGON:
                imagePathBuilder.append(PENTAGON_PATH);
                break;
            case HEXAGON:
                imagePathBuilder.append(HEXAGON_PATH);
                break;
            case BOMB:
                imagePathBuilder.append(BOMB_PATH);
                break;
            default:
                return null;
        }
        return new ImageIcon(SliceableView.class.getResource(imagePathBuilder.toString()));
    }

    /**
     * @param sliceableType
     * @return the height associated with the polygon
     */
    public static int getSliceableHeight(final SliceableTypeEnum sliceableType) {
        switch (sliceableType) {
            case TRIANGLE:
                return TRIANGLE_HEIGHT;
            case SQUARE:
                return SQUARE_HEIGHT;
            case PENTAGON:
                return PENTAGON_HEIGHT;
            case HEXAGON:
                return HEXAGON_HEIGHT;
            case BOMB:
                return BOMB_HEIGHT;
            default:
                return -1;
        }
    }
}
