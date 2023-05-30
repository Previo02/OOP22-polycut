package mvc.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

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

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final String GAME_NAME = "Polycut";
    private static final int BORDER_SIZE = 150;

    /**
     * Creates a simple menu interface.
     * @param container
     * @param buttonPanel
     */
    private void createSimpleMenu(final JFrame container, final JPanel buttonPanel) {
        final JLabel gameTitle = new JLabel(GAME_NAME);
        final JPanel mainPanel = new JPanel();

        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);

        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10));
        buttonPanel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gameTitle, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        //container.setIconImage(null);
        container.setTitle(GAME_NAME);
        container.setSize(WIDTH, HEIGHT);
        container.add(mainPanel, BorderLayout.CENTER);
        container.setBackground(Color.BLACK);
        container.setLocationRelativeTo(null);
        container.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setResizable(false);
        container.pack();
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
