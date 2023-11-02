package mvc.view.impl;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import mvc.model.SliceableTypeEnum;
import mvc.view.GameArea;
import java.awt.Component;
import java.awt.geom.Point2D;

/**
 * GameArea class, it represents the playable area.
 */
public class GameAreaImpl extends JPanel implements GameArea {
    private static final double serialVersionUID = 0L;

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
    public void drawSliceable(final Point2D position, final SliceableTypeEnum type) {
        final int sliceableHeight = SliceableView.getSliceableHeight(type);
        final int sliceableWidth = SliceableView.SLICEABLE_WIDTH;
        final ImageIcon image = SliceableView.getImage(type);

        final JLabel newSliceable = new JLabel(image);
        newSliceable.setBounds((int) position.getX(), (int) position.getY(), sliceableWidth, sliceableHeight);
        // TODO aggiungere evento
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
        this.add(newSliceable);
    }

    /**
     * Update the position of the sliceable.
     * @param newPosition of the sliceable
     * @param type of the sliceable to manage dimensions
     */
    @Override
    public void updatePosition(final Point2D newPosition, final SliceableTypeEnum type) {
        final Component[] components = this.getComponents();
        final int sliceableHeight = SliceableView.getSliceableHeight(type);
        final int sliceableWidth = SliceableView.SLICEABLE_WIDTH;

        for (final Component component : components) {
            if (component instanceof JLabel) {
                final JLabel label = (JLabel) component;
                label.setBounds((int) newPosition.getX(), (int) newPosition.getY(), sliceableWidth, sliceableHeight);
            }
        }
    }
}
