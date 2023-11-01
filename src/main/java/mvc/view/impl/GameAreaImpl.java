package mvc.view.impl;

import mvc.model.SliceableTypeEnum;
import mvc.view.GameArea;
import mvc.view.SliceableView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.Serial;

/**
 * GameArea class, it represents the playable area.
 */
public class GameAreaImpl extends JPanel implements GameArea {

    @Serial
    private static final long serialVersionUID = 0L;
    // private final List<SliceableModel> sliceables;
    private static final int SLICEABLE_WIDTH = 100;
    private final transient SliceableView sliceableView;

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     */
    public GameAreaImpl() {
        // this.sliceables = new ArrayList<>();
        this.sliceableView = new SliceableViewImpl();
        this.setLayout(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLabel drawSliceable(final Point2D position, final SliceableTypeEnum type) {
        final int sliceableHeight = this.sliceableView.getSliceableHeight(type);
        final ImageIcon image = this.sliceableView.getImage(type);
        final JLabel newSliceable = new JLabel(image);

        newSliceable.setBounds((int) position.getX(), (int) position.getY(), SLICEABLE_WIDTH, sliceableHeight);
        newSliceable.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                // if (type.equals(SliceableTypeEnum.BOMB)) {
                //     // gestione bomba: -1 vita
                // } else {
                //     // gestione poligoni: +1 punto
                // }
            }
        });
        this.add(newSliceable);
        return newSliceable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePosition(final JLabel sliceable, final Point2D newPosition, final SliceableTypeEnum type) {
        final int sliceableHeight = this.sliceableView.getSliceableHeight(type);

        sliceable.setBounds((int) newPosition.getX(), (int) newPosition.getY(), SLICEABLE_WIDTH, sliceableHeight);
        this.add(sliceable);
    }

}
