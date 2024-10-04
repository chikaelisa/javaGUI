package components.panel;

import components.MainFrame;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private final JTextArea textArea;

    public TextPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setText(String content) {
        textArea.setText(content);
    }

    public void clearText() {
        textArea.setText("");
    }
}
