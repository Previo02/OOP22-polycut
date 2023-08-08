package mvc;

import mvc.view.Menu;
import mvc.view.impl.ExitButton;
import mvc.view.impl.PlayButton;
import mvc.view.impl.RulesButton;
import mvc.view.impl.SimpleMenu;
import javax.swing.JPanel;
import javax.swing.JFrame;

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
        final Menu menu = new PlayButton(new RulesButton(new ExitButton(new SimpleMenu())));

        final JFrame container = new JFrame();
        final JPanel buttonPanel = new JPanel();

        menu.display(container, buttonPanel);
    }

}
