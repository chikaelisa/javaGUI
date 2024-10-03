package components.menu;

import components.MainFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        mainFrame.getStatusPanel().setStatusLabel("Abrindo arquivo...");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo .txt");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(mainFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            StringBuilder content = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(
                        mainFrame,
                        "Erro ao abrir o arquivo: " + e.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE
                );
                mainFrame.getStatusPanel().setStatusLabel("Erro ao abrir o arquivo!");

                return;
            }

            mainFrame.getTextPanel().setText(content.toString());
            mainFrame.getStatusPanel().setStatusLabel("Arquivo aberto!");
        } else {
            mainFrame.getStatusPanel().setStatusLabel("Abertura de arquivo cancelada!");
        }
    }

    private void onCloseFileMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getTextPanel().clearText();
        mainFrame.getStatusPanel().setStatusLabel("Arquivo fechado!");
    }

    private void onExitMenuItemSelected() {
        System.exit(0);
    }
}
