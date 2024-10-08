package components;

import components.menu.MainMenuBar;
import components.panel.AnimatedPanel;
import components.panel.StatusPanel;
import components.panel.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        textPanel = new TextPanel();
        animatedPanel = new AnimatedPanel();
        statusPanel = new StatusPanel();

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(1, 2));
        containerPanel.add(textPanel);
        containerPanel.add(animatedPanel);

        setJMenuBar(new MainMenuBar(this));
        add(containerPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        setupWindowsListener();
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

    private void setupWindowsListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                getAnimatedPanel().startAnimation();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                getAnimatedPanel().stopAnimation();
            }
        });
    }
}
