package components.menu;

import components.MainFrame;

import javax.swing.*;

public class SettingsMenu extends JMenu {
    public SettingsMenu(MainFrame mainFrame) {
        super("Configurações");

        JMenuItem patternMenuItem = new JMenuItem("Padrões");
        patternMenuItem.addActionListener(e -> onPatternMenuItemSelected());

        JMenuItem colorsMenuItem = new JMenuItem("Cores");
        colorsMenuItem.addActionListener(e -> onColorsMenuItemSelected());

        JMenuItem speedMenuItem = new JMenuItem("Velocidade");
        speedMenuItem.addActionListener(e -> onSpeedMenuItemSelected());

        add(patternMenuItem);
        add(colorsMenuItem);
        add(speedMenuItem);
    }

    private void onPatternMenuItemSelected() {
        // TODO: Implement this function!
    }

    private void onColorsMenuItemSelected() {
        // TODO: Implement this function!
    }

    private void onSpeedMenuItemSelected() {
        // TODO: Implement this function!
    }
}
