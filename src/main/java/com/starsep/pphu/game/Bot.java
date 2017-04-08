package com.starsep.pphu.game;

import com.starsep.pphu.gui.GUI;
import com.starsep.pphu.io.IO;
import com.starsep.pphu.game.building.BuildingFactory;
import com.starsep.pphu.game.building.BuildingType;
import com.starsep.pphu.game.field.Field;

import java.io.IOException;

public class Bot {
    public API api;
    public Map map;
    private int[] matches;
    private GUI gui = null;
    public Game game;

    public Bot(API api) {
        this.api = api;
    }

    public void play() {
        try {
            map = api.getMap();
            matches = api.getMyMatches();
//            BuildingFactory.init(api.getCosts());
            for (int match : matches) {
                game = new Game(match, map, gui, api);
                run(game);
                api.getTurnsLeft();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run(Game game) throws IOException {
        GameMap gameMap = new GameMap(map, game);
        game.setMap(gameMap);
        int match = game.match;
        Field field = map.findNotEmptyField();
        if (field == null) {
            field = map.fields[0][0];
        }
        if (gameMap.setBase(field.row + 2, field.col, 0) != API.INVALID_INT) {
            api.build(match, BuildingType.CORRIDOR_VERTICAL, field.row + 1, field.col);
            api.build(match, field.mineType(), field.row, field.col);
        }
        sellAll(game);
        api.getPoints(match);
    }

    private void sellAll(Game game) throws IOException {
        Resources[] resources = api.getMyResources(game.match);
        if (resources == null) {
            return;
        }
        for (Resources r : resources) {
            api.sell(game.match, r.base, r.alu, r.coal, r.sil, r.uran);
        }

    }

    public void setGUI(GUI gui) {
        this.gui = gui;
        api.setGUI(gui);
    }
}
