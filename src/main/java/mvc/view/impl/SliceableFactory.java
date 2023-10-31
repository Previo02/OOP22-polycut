//package mvc.view.impl;
//
//import mvc.controller.impl.SliceableEnum;
//import mvc.view.SliceableViewFactory;
//
//import java.awt.geom.Point2D;
//
//public class SliceableFactory implements SliceableViewFactory {
//
//    /**
//     * {@inheritDoc}
//     * @param position Where the polygon is created
//     * @param polygonType The type of polygon
//     * @param polygonId The polygon identifier
//     * @return
//     */
//    @Override
//    public Polygon createPolygon(Point2D position, SliceableEnum polygonType, int polygonId) {
//        return new Polygon(position, polygonType, polygonId);
//    }
//
//    /**
//     * {@inheritDoc}
//     * @param position Where the bomb is createdK
//     * @param bombId The bomb identifier
//     * @return
//     */
//    @Override
//    public Bomb createBomb(Point2D position, int bombId) {
//        return new Bomb(position, bombId);
//    }
//}
