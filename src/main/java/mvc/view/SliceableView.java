package mvc.view;

import javax.swing.ImageIcon;

import mvc.model.SliceableTypeEnum;

/**
 * SliceableView interface, contains methods to handle the graphical sliceable object.
 */
public interface SliceableView {

    /**
     * @param sliceableType
     * @return the image associated with the polygon
     */
    ImageIcon getImage(SliceableTypeEnum sliceableType);

    /**
     * @param sliceableType
     * @return the height associated with the polygon
     */
    int getSliceableHeight(SliceableTypeEnum sliceableType);
}
