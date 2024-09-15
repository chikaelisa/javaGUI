package components.menu;

import javax.swing.*;

public class HelpMenu extends JMenu {
    public HelpMenu() {
        super("Ajuda");

        JMenuItem helpMenuItem = new JMenuItem("Ajuda");
        helpMenuItem.addActionListener(e -> onHelpMenuItemSelected());

        JMenuItem aboutMenuItem = new JMenuItem("Sobre");
        aboutMenuItem.addActionListener(e -> onAboutMenuItemSelected());

        add(helpMenuItem);
        add(aboutMenuItem);
    }

    private void onHelpMenuItemSelected() {
        // TODO: Implement this function!
    }

    private void onAboutMenuItemSelected() {
        // TODO: Implement this function!
    }
}
