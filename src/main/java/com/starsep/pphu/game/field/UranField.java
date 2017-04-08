package com.starsep.pphu.game.field;

import com.starsep.pphu.game.building.BuildingType;

import java.awt.*;

public class UranField extends Field {
    @Override
    public int mineType() {
        return BuildingType.MINE_URAN;
    }

    @Override
    public boolean isMineable() {
        return true;
    }

    @Override
    public Color getColor() {
        return new Color(10, 173, 17);
    }

    public UranField(int row, int col) {
        super(row, col);
    }
}
