package mvc.view.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/** 
 * Creates the rules button and adds it to the menu.
*/
public class RulesButton extends MenuDecorator {

    private static final String RULES = "REGOLE\n"
            + "Taglia i poligoni premendo il mouse per ottenere punti\n"
            + "Hai 3 vite a disposizione, non perderle tutte...\n"
            + "Buona fortuna!";

    /**
     * 
     * @param simpleMenu
     */
    public RulesButton(final Menu simpleMenu) {
        super(simpleMenu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display(final JFrame container, final JPanel buttonPanel) {
        final JButton rulesButton = new JButton("Rules");
        rulesButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                JOptionPane.showMessageDialog(container, RULES);
            }

        });
        decorateButton(rulesButton);
        buttonPanel.add(rulesButton);
        super.display(container, buttonPanel);
    }

}
