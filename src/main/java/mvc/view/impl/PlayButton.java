package mvc.view.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.view.Menu;

/**
 * Creates the play button and adds it to the menu.
 */
public class PlayButton extends MenuDecorator {

    /**
     * 
     * @param simpleMenu
     */
    public PlayButton(final Menu simpleMenu) {
        super(simpleMenu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display(final JFrame container, final JPanel buttonPanel) {
        final JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                /* TODO starts the game. */
                container.dispose();
            }

        });
        decorateButton(playButton);
        buttonPanel.add(playButton);
        super.display(container, buttonPanel);
    }

}
