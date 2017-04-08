package com.starsep.pphu.game;

import com.starsep.pphu.game.field.Field;
import com.starsep.pphu.game.field.FieldChar;
import com.starsep.pphu.game.field.FieldFactory;
import com.starsep.pphu.gui.GUI;

import java.awt.*;

public class Map {
    protected Field[][] fields;

    protected Map() { }

    public Map(String[] map) {
        fields = new Field[map.length][];
        for (int i = 0; i < map.length; i++) {
            fields[i] = new Field[map[i].length()];
            for (int j = 0; j < map[i].length(); j++) {
                fields[i][j] = FieldFactory.field(map[i].charAt(j), i, j);
            }
        }
    }

    public Field findNotEmptyField() {
        for (Field[] line : fields) {
            for (Field field : line) {
                if (field.isMineable()) {
                    return field;
                }
            }
        }
        return null;
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        int rows = fields.length;
        int cols = fields[0].length;
        int height = GUI.height / rows;
        int width = GUI.width / cols;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                g.setPaint(fields[r][c].getColor());
                g.fillRect(height * c, width * r, height * (c + 1), width * (r + 1));
                g.setColor(Color.black);
                g.drawRect(height * c, width * r, height * (c + 1), width * (r + 1));
            }
        }
    }
}
