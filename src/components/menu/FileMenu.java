package components.menu;

import components.MainFrame;

import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(MainFrame mainFrame) {
        super("Arquivo");

        JMenuItem openFileMenuItem = new JMenuItem("Abrir arquivo");
        openFileMenuItem.addActionListener(e -> onOpenFileMenuItemSelected(mainFrame));

        JMenuItem closeFileMenuItem = new JMenuItem("Fechar arquivo");
        closeFileMenuItem.addActionListener(e -> onCloseFileMenuItemSelected(mainFrame));

        JMenuItem exitMenuItem = new JMenuItem("Sair");
        exitMenuItem.addActionListener(e -> onExitMenuItemSelected());

        add(openFileMenuItem);
        add(closeFileMenuItem);
        addSeparator();
        add(exitMenuItem);
    }

    private void onOpenFileMenuItemSelected(MainFrame mainFrame) {
        // TODO: Implement this function!

        // Remember that this function should update TextPanel text:
        // mainFrame.getTextPanel().setText(newText);
    }

    private void onCloseFileMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getTextPanel().clearText();
    }

    private void onExitMenuItemSelected() {
        System.exit(0);
    }
}
