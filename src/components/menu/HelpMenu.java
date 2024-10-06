package components.menu;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        File helpFile = new File("src/components/menu/help.txt");
        String content = readFile(helpFile);
        if (content != null) {
            displayContent("Ajuda", content);
        }
    }

    private void onAboutMenuItemSelected() {
        File aboutFile = new File("src/components/menu/about.txt");
        String content = readFile(aboutFile);
        if (content != null) {
            displayContent("Sobre este projeto", content);
        }
    }

    private String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void displayContent(String title, String content) {
        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
