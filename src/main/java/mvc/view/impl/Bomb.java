package mvc.view.impl;

import mvc.view.Sliceable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

/**
 *  Implementation of Bomb element
 */
public class Bomb  extends JLabel implements Sliceable {

    private static final String BOMB_PATH = "src/main/java/mvc/view/GraphicElements/bomb.png";

    /**
     * Refers to the top-left corner of the Image
     */
    Point2D position;
    boolean isVisible;
    boolean isExploded;

    /**
     * Constructor set position
     * @param position top-left corner
     */
    public Bomb(Point2D position){
        this.position = position;
    }

    /**
     * {@inheritDoc}
     * @param isSliced
     */
    @Override
    public void changeVisibility(boolean isSliced) {
        isVisible = !isSliced;
    }

    /** FORSE INUTILE
     * Change the status of the bomb between exploded/not exploded
     * @param isSliced True if it's been sliced
     */
    public void changeStatus(boolean isSliced) {
        isExploded = !isExploded;
    }

    /**
     * {@inheritDoc}
     * @return True if bomb is visible
     */
    @Override
    public boolean isVisible(){
        return isVisible;
    }

    /**
     * Check if bomb is exploded
     * @return True if bomb is exploded
     */
    public boolean isExploded(){
        return isExploded;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public Point2D getPosition() {
        return position;
    }

    /**
     * {@inheritDoc}
     * @param position top-left corner
     */
    @Override
    public void setSliaceablePosition(Point2D position) {
        double xPosition = position.getX();
        double yPosition = position.getY();

        this.setLocation((int)xPosition, (int)yPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSliceStatus() {
        isVisible = !isVisible;
    }

    /**
     * Draw the bomb in GameArea in the specified position
     * @param graphics The Graphics object used for drawing
     */
    public void drawBomb(Graphics graphics){

        int xPosition = (int) position.getX();
        int yPosition = (int) position.getY();
        try {
            Image image = new ImageIcon(BOMB_PATH).getImage();
            graphics.drawImage(image, xPosition, yPosition, this);
            } catch (Exception e) {
            System.out.print("Impossible to draw Bomb!\n Image not found");
        }
    }
}
