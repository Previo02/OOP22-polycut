package mvc.view.menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mvc.controller.impl.GameWorldControllerImpl;
import mvc.view.Menu;

/**
 * Creates the play button and adds it to the menu.
 */
public class PlayButton extends MenuDecorator {

    /**
     * Play button.
     * @param simpleMenu menu
     */
    public PlayButton(final Menu simpleMenu) {
        super(simpleMenu);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void display(final JFrame container, final JPanel buttonPanel) {
        final JButton playButton = new JButton("Play");
        playButton.addActionListener(arg0 -> {
            final var gameWorld = new GameWorldControllerImpl();
            container.dispose();
            gameWorld.startLoop();
        });
        decorateButton(playButton);
        buttonPanel.add(playButton);
        super.display(container, buttonPanel);
    }

}
