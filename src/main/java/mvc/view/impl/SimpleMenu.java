package mvc.view.impl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mvc.view.Menu;

/**
 * SimpleMenu class sets up a basic menu.
 */
public class SimpleMenu implements Menu {

    private static final String GAME_NAME = "Polycut";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private static final int TOP_GAP = 50;
    private static final int BUTTON_H_GAP = 50;
    private static final int LABEL_FONT_SIZE = 40;
    private static final int LABEL_FONT_STYLE = Font.PLAIN;
    // private static final Color BACKGROUND_COLOR = Color.ORANGE;

    /**
     * Creates a simple menu interface.
     * @param container
     * @param buttonPanel
     */
    private void createSimpleMenu(final JFrame container, final JPanel buttonPanel) {
        final JLabel gameTitle = new JLabel(GAME_NAME);
        final Font font = new Font(gameTitle.getFont().getName(), LABEL_FONT_STYLE, LABEL_FONT_SIZE);

        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gameTitle.setFont(font);
        gameTitle.setBorder(new EmptyBorder(TOP_GAP, 0, 0, 0));

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, BUTTON_H_GAP, 0));

        // container.setIconImage(null);
        container.setTitle(GAME_NAME);
        container.setSize(WIDTH, HEIGHT);
        container.setResizable(false);
        container.setLayout(new BorderLayout(0, TOP_GAP));
        container.add(gameTitle, BorderLayout.PAGE_START);
        container.add(buttonPanel, BorderLayout.CENTER);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display(final JFrame container, final JPanel buttonPanel) {
        createSimpleMenu(container, buttonPanel);
        container.setVisible(true);
    }

}
