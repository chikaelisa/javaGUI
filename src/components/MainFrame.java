package components;

import components.panel.TextPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final TextPanel textPanel;

    public MainFrame() {
        setTitle("Java GUI application");
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textPanel = new TextPanel(this);
        add(textPanel, BorderLayout.CENTER);
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }
}
