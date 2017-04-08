package com.starsep.pphu.game.field;

import com.starsep.pphu.game.building.Building;

import java.awt.*;

public abstract class Field {
    public final int row;
    public final int col;
    public Building building;

    public Field(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int mineType() {
        return -1;
    }

    public abstract boolean isMineable();

    public abstract Color getColor();
}
