package mvc;

import mvc.view.menu.ExitButton;
import mvc.view.menu.Menu;
import mvc.view.menu.PlayButton;
import mvc.view.menu.RulesButton;
import mvc.view.menu.SimpleMenu;
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
