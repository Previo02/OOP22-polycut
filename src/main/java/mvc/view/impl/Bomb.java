//package mvc.view.impl;
//
//import mvc.view.SliceableView;
//
//import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.geom.Point2D;
//import java.io.Serial;
//
///**
// *  Implementation of Bomb element.
// */
//public class Bomb extends JLabel implements SliceableView {
//    @Serial
//    private static final long serialVersionUID = 0L;
//    public static final String BOMB_PATH = "src\\main\\java\\mvc\\view\\GraphicElements\\bomb.png";
//    public static final int BOMB_WIDTH = 100;
//    public static final int BOMB_HEIGHT = 98;
//
//    /**
//     * Refers to the top-left corner of the Image.
//     */
//    private Point2D position;
//    private boolean isVisible;
//    private boolean isExploded;
//    private final int bombId;
//
//    /**
//     * Constructor set position and identifier.
//     * @param position top-left corner
//     * @param bombId
//     */
//    public Bomb(final Point2D position, final int bombId) {
//        this.position = new Point2D.Double(position.getX(), position.getY());
//        this.bombId = bombId;
//    }
//
//    /**
//     * {@inheritDoc}.
//     * @param isSliced
//     */
//    @Override
//    public void changeVisibility(final boolean isSliced) {
//        isVisible = !isSliced;
//    }
//
//    /**
//     * Change the status of the bomb between exploded/not exploded.
//     * @param isSliced True if it's been sliced .
//     */
//    public void changeStatus(final boolean isSliced) {
//        isExploded = !isExploded;
//    }
//
//    /**
//     * {@inheritDoc}.
//     * @return True if bomb is visible.
//     */
//    @Override
//    public boolean isVisible() {
//        return isVisible;
//    }
//
//    /**
//     * Check if bomb is exploded.
//     * @return True if bomb is exploded.
//     */
//    public boolean isExploded() {
//        return isExploded;
//    }
//
//    /**
//     * {@inheritDoc}.
//     * @return position.
//     */
//    @Override
//    public Point2D getPosition() {
//        return new Point2D.Double(this.position.getX(), this.position.getY());
//    }
//
//    /**
//     * {@inheritDoc}.
//     * @param position top-left corner
//     */
//    @Override
//    public void setSliceablePosition(final Point2D position) {
//        final double xPosition = position.getX();
//        final double yPosition = position.getY();
//
//        this.setLocation((int) xPosition, (int) yPosition);
//    }
//
//    /**
//     * {@inheritDoc}.
//     */
//    @Override
//    public void setSliceStatus() {
//        isVisible = !isVisible;
//    }
//
//    /**
//     * Draw the bomb in GameArea in the specified position.
//     * @param graphics The Graphics object used for drawing
//     */
//    public void drawBomb(final Graphics graphics) {
//
//        final int xPosition = (int) position.getX();
//        final int yPosition = (int) position.getY();
//        final Image image = new ImageIcon(BOMB_PATH).getImage();
//        graphics.drawImage(image, xPosition, yPosition, this);
//    }
//
//    /**
//     * {@inheritDoc}.
//     */
//    @Override
//    public void setPosition(final Point2D newPos) {
//        this.position = new Point2D.Double(newPos.getX(), newPos.getY());
//    }
//
//    /**
//     * {@inheritDoc}.
//     */
//    @Override
//    public int getSliceableId() {
//        return this.bombId;
//    }
//
//}
