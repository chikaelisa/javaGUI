package components.menu;

import components.MainFrame;
import utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class FileMenu extends JMenu {
    public FileMenu(MainFrame mainFrame) {
        super("Arquivo");

        JMenuItem openFileMenuItem = new JMenuItem("Abrir arquivo");
        openFileMenuItem.addActionListener(e -> onOpenFileMenuItemSelected(mainFrame));

        JMenuItem closeFileMenuItem = new JMenuItem("Fechar arquivo");
        closeFileMenuItem.addActionListener(e -> onCloseFileMenuItemSelected(mainFrame));

        JMenuItem exitMenuItem = new JMenuItem("Sair");
        exitMenuItem.addActionListener(e -> onExitMenuItemSelected(mainFrame));

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
            String content = FileUtils.readFile(selectedFile);

            if (content != null) {
                mainFrame.getTextPanel().setText(content);
                mainFrame.getStatusPanel().setStatusLabel("Arquivo aberto!");
            } else {
                JOptionPane.showMessageDialog(
                        mainFrame,
                        "Erro ao abrir o arquivo: O conteúdo está vazio ou ocorreu um erro na leitura.",
                        "Erro", JOptionPane.ERROR_MESSAGE
                );
                mainFrame.getStatusPanel().setStatusLabel("Erro ao abrir o arquivo!");
            }
        } else {
            mainFrame.getStatusPanel().setStatusLabel("Abertura de arquivo cancelada!");
        }
    }

    private void onCloseFileMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getTextPanel().clearText();
        mainFrame.getStatusPanel().setStatusLabel("Arquivo fechado!");
    }

    private void onExitMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().stopAnimation();
        System.exit(WindowConstants.EXIT_ON_CLOSE);
    }
}
