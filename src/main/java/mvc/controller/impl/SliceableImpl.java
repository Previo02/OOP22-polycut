package mvc.controller.impl;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class SliceableImpl {

    @Serial
    private static final long serialVersionUID = 0L;
    private static final String TRIANGLE_PATH = "src/main/java/mvc/view/GraphicElements/triangle.png";
    private static final String SQUARE_PATH = "src/main/java/mvc/view/GraphicElements/square.png";
    private static final String PENTAGON_PATH = "src/main/java/mvc/view/GraphicElements/pentagon.png";
    private static final String HEXAGON_PATH = "src/main/java/mvc/view/GraphicElements/hexagon.png";
    public static final String BOMB_PATH = "src/main/java/mvc/view/GraphicElements/bomb.png";
    // The same for every Sliceable
    public static final int SLICEABLE_WIDTH = 100;

    private static final int HEXAGON_HEIGHT = 113;
    private static final int PENTAGON_HEIGHT = 97;
    private static final int SQUARE_HEIGHT = 98;
    private static final int TRIANGLE_HEIGHT = 88;
    public static final int BOMB_HEIGHT = 98;

    private SliceableEnum sliceableType;
//    //potenzialmente inutili
//     private boolean isVisible;
//     private Point2D position;

    public static ImageIcon getImage(final SliceableEnum SliceableType) {
        switch (SliceableType) {
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

    public static int getPolygonHeight(SliceableEnum sliceableType){
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
        }
        return -1;
    }
}
