package mvc.view.impl;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import mvc.model.SliceableTypeEnum;
import mvc.view.GameArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * GameArea class, it represents the playable area.
 */
public class GameAreaImpl extends JPanel implements GameArea {
    private static final long serialVersionUID = 0L;
    private static Map<Integer, JLabel> labelMap = new HashMap<>();
    private final LiveImpl lives;
    private final ScoreViewImpl score;
    private final List<Integer> sliceablesID;

    /**
     * Constructor initiates a list of Bombs and Polygon present in the GameArea.
     * @param lives current lives
     * @param score current score
     */
    @SuppressFBWarnings
    public GameAreaImpl(final LiveImpl lives, final ScoreViewImpl score) {
        this.lives = lives;
        this.score = score;
        this.sliceablesID = new ArrayList<>();
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
        newSliceableLabel.setEnabled(true);
        newSliceableLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                if (type.equals(SliceableTypeEnum.BOMB)) {
                   lives.decreaseLives();
                } else {
                    score.increaseScore();
                }
                sliceablesID.add(sliceableID);
                clean(sliceableID);
                revalidate();
                repaint();
            }
        });
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
        if (Objects.nonNull(currLabel)) {
            this.remove(currLabel);
        }
        labelMap.remove(sliceableID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getSliced() {
        return new ArrayList<>(this.sliceablesID);
    }
}
