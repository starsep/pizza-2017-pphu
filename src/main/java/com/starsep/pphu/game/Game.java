package com.starsep.pphu.game;

import com.starsep.pphu.gui.GUI;

public class Game {
    public final int match;
    public Map map;
    private GUI gui;
    public final API api;

    public Game(int match, Map map, GUI gui, API api) {
        this.map = map;
        this.match = match;
        this.gui = gui;
        this.api = api;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
