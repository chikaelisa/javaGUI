package components.dialog;

import javax.swing.*;
import java.awt.*;

public class HelpDialog {
    private final JDialog dialog;

    public HelpDialog(String title, String content, ImageIcon icon) {
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.setSize(800, 700);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea(content);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setPreferredSize(new Dimension(380, 240));

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(textScrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(imageLabel);

        JScrollPane mainScrollPane = new JScrollPane(mainPanel);
        mainScrollPane.setPreferredSize(new Dimension(380, 300));

        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dialog.dispose());

        JPanel dialogPanel = new JPanel(new BorderLayout());
        dialogPanel.add(mainScrollPane, BorderLayout.CENTER);
        dialogPanel.add(closeButton, BorderLayout.SOUTH);

        dialog.getContentPane().add(dialogPanel);
    }

    public void show() {
        dialog.setVisible(true);
    }
}
