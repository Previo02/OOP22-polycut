package mvc;

import mvc.controller.GameWorldController;
import mvc.controller.GameWorldControllerImpl;
import mvc.controller.PhysicController;
import mvc.controller.PhysicControllerImpl;

/**
 * Main application of the program.
 */
public final class App {

    private App() {
    }

    /**
    * Main method of the program.
    * @param args main arguments.
    */
    public static void main(final String[] args) {

        // var model = new SliceableImpl(4, 4, new Point2D.Double(0, 0), new Point2D.Double(10, 10));
        // var view = new SliceableViewImpl(new Point2D.Double(0, 0), PolygonEnum.SQUARE);
        // var controller = new Controller();
        // var controller2 = new Controller(model, view);
        // controller2.updatePosition();
        // controller.createPolygons();

        // Esempio: aggiorna la posizione del poligono ogni 100 millisecondi
        // Timer timer = new Timer(100, new ActionListener() {

        //     @Override
        //     public void actionPerformed(java.awt.event.ActionEvent arg0) {
        //         controller.createPolygons();;
        //     }

        // });
        // timer.start();

        // Uncomment to run the application

        // final Menu menu = new PlayButton(new RulesButton(new ExitButton(new SimpleMenu())));

        // final JFrame container = new JFrame();
        // final JPanel buttonPanel = new JPanel();

        // menu.display(container, buttonPanel);

        final GameWorldController worldController = new GameWorldControllerImpl();
        final PhysicController physicController = new PhysicControllerImpl(1, worldController);

        worldController.createSliceables();
        physicController.updateSliceablesPosition();
    }

}
