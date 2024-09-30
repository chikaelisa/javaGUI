package components.panel;

import utils.Pattern;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnimatedPanel extends JPanel {
    private boolean running = true;
    private final Random rand = new Random();

    private Pattern pattern = Pattern.LINE;
    private Color backgroundColor = Color.RED;
    private int speed = 5000;

    public AnimatedPanel() {
    }

    @Override
    public void paint(Graphics canvasOriginal) {
        super.paint(canvasOriginal);
        Graphics2D canvas = (Graphics2D) canvasOriginal;

        setForeground(Color.WHITE);
        setBackground(backgroundColor);

        int maxX = this.getWidth();
        int maxY = this.getHeight();
        int limit = rand.nextInt(200);

        for (int i = 0; i < limit; i++) {
            switch (pattern) {
                case LINE:
                    canvas.drawLine(
                            rand.nextInt(maxX), rand.nextInt(maxY),
                            rand.nextInt(maxX), rand.nextInt(maxY)
                    );
                    break;

                case OVAL:
                    canvas.drawOval(
                            rand.nextInt(maxX), rand.nextInt(maxY),
                            rand.nextInt((int) (maxX * 0.9)), rand.nextInt((int) (maxY * 0.9))
                    );
                    break;

                case RECT:
                    canvas.drawRect(
                            rand.nextInt(maxX), rand.nextInt(maxY),
                            rand.nextInt((int) (maxX * 0.9)), rand.nextInt((int) (maxY * 0.9))
                    );
                    break;
            }

        }
    }

    public void startAnimation() {
        Thread animationThread = new Thread(() -> {
            while (running) {
                repaint();

                try {
                    Thread.sleep(speed);
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

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
