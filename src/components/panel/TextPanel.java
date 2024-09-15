package components.panel;

import components.MainFrame;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;

    public TextPanel(MainFrame mainFrame) {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension((int) (mainFrame.getHeight() * 0.80), (int) (mainFrame.getWidth() * 0.80)));
    }

    public void setText(String content) {
        textArea.setText(content);
    }

    public void clearText() {
        textArea.setText("");
    }
}
