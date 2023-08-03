package mvc;

import mvc.view.Menu;
import mvc.view.impl.*;

import javax.swing.*;

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

        var game = new GameScreen();
        game.createAndShowGui();

//        final Menu menu = new PlayButton(new RulesButton(new ExitButton(new SimpleMenu())));
//
//        final JFrame container = new JFrame();
//        final JPanel buttonPanel = new JPanel();

//        menu.display(container, buttonPanel);
    }

}
