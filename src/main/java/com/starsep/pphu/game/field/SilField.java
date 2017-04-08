package com.starsep.pphu.game.field;

import com.starsep.pphu.game.building.BuildingType;

import java.awt.*;

public class SilField extends Field {
    @Override
    public int mineType() {
        return BuildingType.MINE_SIL;
    }

    @Override
    public boolean isMineable() {
        return true;
    }

    @Override
    public Color getColor() {
        return new Color(39, 41, 170);
    }

    public SilField(int row, int col) {
        super(row, col);
    }
}
