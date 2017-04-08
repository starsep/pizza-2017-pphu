package com.starsep.pphu.gui;

import com.starsep.pphu.game.Bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JComponent {
    public final static int height = 800;
    public final static int width = 800;
    private Timer timer;

    private final Bot bot;

    public GUI(Bot bot) {
        this.bot = bot;
        setVisible(true);
        setSize(height, width);
        timer = new Timer(1000, actionEvent -> repaint());
        timer.start();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        if (bot.game != null) {
            bot.game.map.paint(g);
        }
        g.setPaint(Color.orange);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        g.drawString("TURNS LEFT " + bot.api.getTurnsLeft(), 0, 750);
    }
}
