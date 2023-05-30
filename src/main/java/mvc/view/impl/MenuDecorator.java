package mvc.view.impl;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mvc.view.Menu;

/**
 * MenuDecorator class models a simple menu without nothing but the screen, is used for decorate the menu with other objects.
 */
public class MenuDecorator extends SimpleMenu {

    private final Menu simpleMenu;

    /**
     * 
     * @param simpleMenu
     */
    public MenuDecorator(final Menu simpleMenu) {
        this.simpleMenu = simpleMenu;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display(final JFrame container, final JPanel buttonPanel) {
        simpleMenu.display(container, buttonPanel);
    }

}
