package components.menu;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

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
            showHelpDialog(content);
        }
    }

    private void onAboutMenuItemSelected() {
        File aboutFile = new File("src/components/menu/about.txt");
        String content = readFile(aboutFile);
        if (content != null) {
            displayContent(content);
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

    private void displayContent(String content) {
        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Sobre este projeto", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showHelpDialog(String content) {
        JDialog helpDialog = new JDialog();
        helpDialog.setTitle("Ajuda");
        helpDialog.setSize(800, 700);
        helpDialog.setLocationRelativeTo(null);
        helpDialog.setModal(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setPreferredSize(new Dimension(380, 240));

        ImageIcon icon = new ImageIcon(getClass().getResource("/components/menu/fileMenu.png"));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(textScrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(imageLabel);

        JScrollPane mainScrollPane = new JScrollPane(mainPanel);
        mainScrollPane.setPreferredSize(new Dimension(380, 300));

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> helpDialog.dispose());

        JPanel dialogPanel = new JPanel(new BorderLayout());
        dialogPanel.add(mainScrollPane, BorderLayout.CENTER);
        dialogPanel.add(closeButton, BorderLayout.SOUTH);

        helpDialog.getContentPane().add(dialogPanel);
        helpDialog.setVisible(true);
    }


}
