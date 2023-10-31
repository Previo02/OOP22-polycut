package mvc.view.impl;

import javax.swing.*;

import mvc.controller.impl.SliceableEnum;
import mvc.controller.impl.SliceableImpl;
import mvc.model.Sliceable;
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
    private final List<Sliceable> sliceables;


    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     */
    public GameArea() {
        this.sliceables = new ArrayList<>();
        this.setLayout(null);
    }

    /**
     * Create The Sliceable and attach the listener
     * @param position the initial position
     * @param type of Sliceable, to manage mouse listener and dimensions
     */
    public void drawSliceable(Point2D position, SliceableEnum type){
        int sliceableHeight = SliceableImpl.getPolygonHeight(type);
        int sliceableWidth = SliceableImpl.SLICEABLE_WIDTH;
        ImageIcon image = SliceableImpl.getImage(type);

        JLabel newSliceable = new JLabel(image);
        newSliceable.setBounds((int)position.getX(),(int)position.getY(),sliceableWidth,sliceableHeight);
        newSliceable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(type.equals(SliceableEnum.BOMB)){
                    // gestione bomba: -1 vita
                }
                else{
                    // gestione poligoni: +1 punto
                }
            }
        });
        this.add(newSliceable);
    }

    /**
     * Update the position of the sliceable
     * @param sliceable to update position
     * @param newPosition of the sliceable
     * @param type of the sliceable to manage dimensions
     */
    public void updatePosition(JLabel sliceable, Point2D newPosition,SliceableEnum type ){
        int sliceableHeight = SliceableImpl.getPolygonHeight(type);
        int sliceableWidth = SliceableImpl.SLICEABLE_WIDTH;

        sliceable.setBounds((int)newPosition.getX(),(int)newPosition.getY(),sliceableWidth,sliceableHeight);
    }

    public List<Sliceable> getSliceables() {
        return new ArrayList<>(this.sliceables);
    }
}
