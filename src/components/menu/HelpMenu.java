package components.menu;

import components.MainFrame;
import components.dialog.HelpDialog;
import utils.FileUtils;

import javax.swing.*;
import java.io.File;


public class HelpMenu extends JMenu {
    public HelpMenu(MainFrame mainFrame) {
        super("Ajuda");

        JMenuItem helpMenuItem = new JMenuItem("Ajuda");
        helpMenuItem.addActionListener(e -> onHelpMenuItemSelected(mainFrame));

        JMenuItem aboutMenuItem = new JMenuItem("Sobre");
        aboutMenuItem.addActionListener(e -> onAboutMenuItemSelected(mainFrame));

        add(helpMenuItem);
        add(aboutMenuItem);
    }

    private void onHelpMenuItemSelected(MainFrame mainFrame) {
        File helpFile = new File("src/assets/help.txt");
        String content = FileUtils.readFile(helpFile);
        if (content != null) {
            mainFrame.getStatusPanel().setStatusLabel("Ajuda");
            ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fileMenu.png"));
            HelpDialog helpDialog = new HelpDialog("Ajuda", content, icon);
            helpDialog.show();
        } else {
            mainFrame.getStatusPanel().setStatusLabel("Erro ao abrir Ajuda");
        }

    }

    private void onAboutMenuItemSelected(MainFrame mainFrame) {
        File aboutFile = new File("src/assets/about.txt");
        String content = FileUtils.readFile(aboutFile);
        if (content != null) {
            mainFrame.getStatusPanel().setStatusLabel("Sobre o projeto");
            FileUtils.displayContent(content, "Sobre este projeto");
        } else {
            mainFrame.getStatusPanel().setStatusLabel("Erro ao abrir Sobre o projeto");
        }
    }

}
