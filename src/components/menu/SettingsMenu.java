package components.menu;

import components.MainFrame;
import utils.Pattern;

import javax.swing.*;
import java.awt.*;

public class SettingsMenu extends JMenu {
    public SettingsMenu(MainFrame mainFrame) {
        super("Configurações");

        /* PattensMenu */

        JMenu patternsMenu = new JMenu("Padrões");

        JMenuItem linePatternMenuItem = new JMenuItem("Linha");
        linePatternMenuItem.addActionListener(e -> onLinePatternMenuItemSelected(mainFrame));

        JMenuItem ovalPatternMenuItem = new JMenuItem("Oval");
        ovalPatternMenuItem.addActionListener(e -> onOvalPatternMenuItemSelected(mainFrame));

        JMenuItem rectPatternMenuItem = new JMenuItem("Retângulo");
        rectPatternMenuItem.addActionListener(e -> onRectPatternMenuItemSelected(mainFrame));

        patternsMenu.add(linePatternMenuItem);
        patternsMenu.add(ovalPatternMenuItem);
        patternsMenu.add(rectPatternMenuItem);

        /* ColorsMenu */

        JMenu colorsMenu = new JMenu("Cores");

        JMenuItem redColorMenuItem = new JMenuItem("Vermelho");
        redColorMenuItem.addActionListener(e -> onRedColorMenuItemSelected(mainFrame));

        JMenuItem greenColorMenuItem = new JMenuItem("Verde");
        greenColorMenuItem.addActionListener(e -> onGreenColorMenuItemSelected(mainFrame));

        JMenuItem blueColorMenuItem = new JMenuItem("Azul");
        blueColorMenuItem.addActionListener(e -> onBlueColorMenuItemSelected(mainFrame));

        colorsMenu.add(redColorMenuItem);
        colorsMenu.add(greenColorMenuItem);
        colorsMenu.add(blueColorMenuItem);

        /* SpeedMenu */

        JMenu speedMenu = new JMenu("Velocidade");

        JMenuItem lowSpeedMenuItem = new JMenuItem("Lento");
        lowSpeedMenuItem.addActionListener(e -> onLowSpeedMenuItemSelected(mainFrame));

        JMenuItem mediumSpeedMenuItem = new JMenuItem("Médio");
        mediumSpeedMenuItem.addActionListener(e -> onMediumSpeedMenuItemSelected(mainFrame));

        JMenuItem highSpeedMenuItem = new JMenuItem("Rápido");
        highSpeedMenuItem.addActionListener(e -> onHighSpeedMenuItemSelected(mainFrame));

        speedMenu.add(lowSpeedMenuItem);
        speedMenu.add(mediumSpeedMenuItem);
        speedMenu.add(highSpeedMenuItem);

        /* settingsMenu */

        add(patternsMenu);
        add(colorsMenu);
        add(speedMenu);
    }

    private void onLinePatternMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setPattern(Pattern.LINE);
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Padrão linhas selecionado!");
    }

    private void onOvalPatternMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setPattern(Pattern.OVAL);
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Padrão oval selecionado!");
    }

    private void onRectPatternMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setPattern(Pattern.RECT);
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Padrão retângulos selecionado!");
    }

    private void onRedColorMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setBackgroundColor(Color.RED);
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Cor vermelho selecionada!");
    }

    private void onGreenColorMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setBackgroundColor(Color.decode("#007F2F"));
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Cor verde selecionada!");
    }

    private void onBlueColorMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setBackgroundColor(Color.BLUE);
        mainFrame.getAnimatedPanel().repaint();
        mainFrame.getStatusPanel().setStatusLabel("Cor azul selecionada!");
    }

    private void onLowSpeedMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setSpeed(5000);
        mainFrame.getStatusPanel().setStatusLabel("Velocidade lenta selecionada!");
    }

    private void onMediumSpeedMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setSpeed(2500);
        mainFrame.getStatusPanel().setStatusLabel("Velocidade média selecionada!");
    }

    private void onHighSpeedMenuItemSelected(MainFrame mainFrame) {
        mainFrame.getAnimatedPanel().setSpeed(1000);
        mainFrame.getStatusPanel().setStatusLabel("Velocidade rápida selecionada!");
    }
}
