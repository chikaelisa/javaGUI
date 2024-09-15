package components.panel;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    private boolean running = true;
    private int pattern; // TODO: Evaluate what pattern will handle on the animation
    private Color color = Color.BLUE;
    private int speed = 100;

    public AnimationPanel() { }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void startAnimation() {
        Thread animationThread = new Thread(() -> {
            while (running) {
                repaint();
                try {
                    Thread.sleep(speed); // Controla a velocidade da animação
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException: " + e);
                }
            }
        });
        animationThread.start();
    }

    public void stopAnimation() {
        running = false;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
