package mvc.view.menu;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MenuDecorator class models a simple menu without nothing but the screen, is used for decorate the menu with other objects.
 */
public class MenuDecorator extends SimpleMenu {

    private static final int BUTTON_FONT_SIZE = 20;
    private static final int BUTTON_FONT_STYLE = Font.PLAIN;

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

    /**
     * Decorates the specified button.
     * @param button
     */
    protected void decorateButton(final JButton button) {
        button.setFont(new Font(button.getFont().getName(), BUTTON_FONT_STYLE, BUTTON_FONT_SIZE));
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

}
