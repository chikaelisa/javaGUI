package components.panel;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private final JLabel statusLabel;

    public StatusPanel() {
        statusLabel = new JLabel();
        add(statusLabel);
        setBackground(Color.gray);
    }

    public void setStatusLabel(String newStatusLabel) {
        statusLabel.setText(newStatusLabel);
    }
}
