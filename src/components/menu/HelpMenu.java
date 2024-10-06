package components.menu;

import components.dialog.HelpDialog;
import utils.FileUtils;

import javax.swing.*;
import java.io.File;


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
        File helpFile = new File("src/assets/help.txt");
        String content = FileUtils.readFile(helpFile);
        if (content != null) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fileMenu.png"));
            HelpDialog helpDialog = new HelpDialog("Ajuda", content, icon);
            helpDialog.show();
        }
    }

    private void onAboutMenuItemSelected() {
        File aboutFile = new File("src/assets/about.txt");
        String content = FileUtils.readFile(aboutFile);
        if (content != null) {
            FileUtils.displayContent(content, "Sobre este projeto");
        }
    }

}
