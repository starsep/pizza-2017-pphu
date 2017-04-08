package com.starsep.pphu.gui;

import com.starsep.pphu.game.Bot;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow(Bot bot) {
        setSize(GUI.width, GUI.height + 30);
        GUI gui = new GUI(bot);
        add(gui);
        bot.setGUI(gui);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    }

    public static void launchGUI(Bot bot) {
        EventQueue.invokeLater(() -> {
            MainWindow window = new MainWindow(bot);
            window.setVisible(true);
        });
    }
}
