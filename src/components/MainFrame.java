package components;

import components.menu.MainMenuBar;
import components.panel.AnimatedPanel;
import components.panel.StatusPanel;
import components.panel.TextPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final TextPanel textPanel;
    private final AnimatedPanel animatedPanel;
    private final StatusPanel statusPanel;

    public MainFrame() {
        setTitle("Java GUI application");
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setJMenuBar(new MainMenuBar(this));
        textPanel = new TextPanel(this);
        animatedPanel = new AnimatedPanel();
        statusPanel = new StatusPanel();

        add(textPanel, BorderLayout.WEST);
        add(animatedPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        animatedPanel.startAnimation();
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public AnimatedPanel getAnimatedPanel() {
        return animatedPanel;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }
}
