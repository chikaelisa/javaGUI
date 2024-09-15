package components.menu;

import components.MainFrame;

import javax.swing.*;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar(MainFrame mainFrame) {
        add(new FileMenu(mainFrame));
        add(new SettingsMenu(mainFrame));
        add(new HelpMenu());
    }
}
