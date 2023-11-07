package mvc.view.impl;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import mvc.model.SliceableTypeEnum;
import mvc.view.GameArea;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

/**
 * GameArea class, it represents the playable area.
 */
public class GameAreaImpl extends JPanel implements GameArea {
    private static final double serialVersionUID = 0L;
    private static Map<Integer, JLabel> labelMap = new HashMap<>();

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     */
    public GameAreaImpl() {
        this.setLayout(null);
    }

    /**
     * Create The Sliceable and attach the listener.
     * @param position the initial position
     * @param type of Sliceable, to manage mouse listener and dimensions
     */
    @Override
    public void drawSliceable(final Integer sliceableID, final Point2D position, final SliceableTypeEnum type) {
        final int sliceableHeight = SliceableView.getSliceableHeight(type);
        final int sliceableWidth = SliceableView.SLICEABLE_WIDTH;
        final int posX = (int) position.getX();
        final int posY = (int) position.getY();
        final ImageIcon image = SliceableView.getImage(type);

        final JLabel newSliceableLabel = new JLabel(image);
        newSliceableLabel.setBounds(posX, posY, sliceableWidth, sliceableHeight);
        /*TODO aggiungere evento*/
//        newSliceable.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(final MouseEvent e) {
//                if (type.equals(SliceableTypeEnum.BOMB)) {
//                    // gestione bomba: -1 vita
//                } else {
//                    // gestione poligoni: +1 punto
//                }
//            }
//        });
        labelMap.put(sliceableID, newSliceableLabel);
        this.add(newSliceableLabel);
    }

    /**
     * Update the position of the sliceable.
     * @param newPosition of the sliceable
     * @param type of the sliceable to manage dimensions
     */
    @Override
    public void updatePosition(final Point2D newPosition, final SliceableTypeEnum type) {
        final int sliceableHeight = SliceableView.getSliceableHeight(type);
        final int sliceableWidth = SliceableView.SLICEABLE_WIDTH;

        for (final var entry : labelMap.entrySet()) {
            final JLabel label = entry.getValue();
            label.setBounds((int) newPosition.getX(), (int) newPosition.getY(), sliceableWidth, sliceableHeight);
        }
        /* Repaint the game area, otherwise the labels remain attached to the panel */
        this.revalidate();
        this.repaint();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void clean(final Integer sliceableID) {
        final var currLabel = labelMap.get(sliceableID);
        this.remove(currLabel);
        labelMap.remove(sliceableID);
    }
}
