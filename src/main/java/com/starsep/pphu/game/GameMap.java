package com.starsep.pphu.game;

import com.starsep.pphu.game.building.Base;
import com.starsep.pphu.game.building.Building;
import com.starsep.pphu.game.field.Field;
import com.starsep.pphu.gui.GUI;
import com.starsep.pphu.io.IO;

import java.awt.*;

public class GameMap extends Map {
    private Game game;

    public GameMap(Map map, Game game) {
        this.game = game;
        fields = map.fields;
    }

    public int setBase(int row, int col, int founder) {
        int res = game.api.setBase(game.match, row, col, founder);
        if (res != API.INVALID_INT) {
            fields[row][col].building = new Base(res, fields[row][col]);
        }
        return res;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        int rows = fields.length;
        int cols = fields[0].length;
        int height = GUI.height / rows;
        int width = GUI.width / cols;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (fields[r][c].building != null) {
                    Building building = fields[r][c].building;
                    g.setPaint(Color.darkGray);
                    g.fillRoundRect(height * c, width * r, height * (c + 1), width * (r + 1), 90, 90);
                }
            }
        }
    }
}
