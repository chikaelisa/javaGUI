package components;

import components.panel.AnimationPanel;
import components.panel.TextPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final TextPanel textPanel;
    private final AnimationPanel animationPanel;

    public MainFrame() {
        setTitle("Java GUI application");
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.5));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textPanel = new TextPanel(this);
        animationPanel = new AnimationPanel();

        add(textPanel, BorderLayout.WEST);
        add(animationPanel, BorderLayout.CENTER);

        animationPanel.startAnimation();
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public AnimationPanel getAnimationPanel() {
        return animationPanel;
    }
}
