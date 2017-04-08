package com.starsep.pphu.game.field;

import com.starsep.pphu.game.building.BuildingType;

import java.awt.*;

public class CoalField extends Field {
    @Override
    public int mineType() {
        return BuildingType.MINE_COAL;
    }

    @Override
    public boolean isMineable() {
        return true;
    }

    @Override
    public Color getColor() {
        return new Color(30, 26, 27);
    }

    public CoalField(int row, int col) {
        super(row, col);
    }
}
