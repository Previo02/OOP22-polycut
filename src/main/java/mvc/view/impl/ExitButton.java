package mvc.view.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.view.Menu;

/** 
 * Creates the exit button and adds it to the menu.
*/
public class ExitButton extends MenuDecorator {

    /**
     * 
     * @param simpleMenu
     */
    public ExitButton(final Menu simpleMenu) {
        super(simpleMenu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display(final JFrame container, final  JPanel buttonPanel) {
        final JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                container.dispose();
            }
 
        });
        decorateButton(exitButton);
        buttonPanel.add(exitButton);
        super.display(container, buttonPanel);
    }

}
