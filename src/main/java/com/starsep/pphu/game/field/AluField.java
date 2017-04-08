package com.starsep.pphu.game.field;

import com.starsep.pphu.game.building.BuildingType;

import java.awt.*;

public class AluField extends Field {
    @Override
    public int mineType() {
        return BuildingType.MINE_ALU;
    }

    @Override
    public boolean isMineable() {
        return true;
    }

    @Override
    public Color getColor() {
        return new Color(118, 123, 123);
    }

    public AluField(int row, int col) {
        super(row, col);
    }
}
