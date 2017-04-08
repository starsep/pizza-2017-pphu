package com.starsep.pphu.game.field;

import java.awt.*;

public class NormalField extends Field {
    public NormalField(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean isMineable() {
        return false;
    }

    @Override
    public Color getColor() {
        return new Color(249, 255, 253);
    }
}
