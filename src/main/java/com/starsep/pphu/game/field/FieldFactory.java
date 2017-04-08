package com.starsep.pphu.game.field;

import com.starsep.pphu.io.IO;

public class FieldFactory {
    public static Field field(char c, int row, int col) {
        switch (c) {
            case FieldChar.NORMAL:
                return new NormalField(row, col);
            case FieldChar.ALU:
                return new AluField(row, col);
            case FieldChar.COAL:
                return new CoalField(row, col);
            case FieldChar.SIL:
                return new SilField(row, col);
            case FieldChar.URAN:
                return new UranField(row, col);
            default:
                IO.error("Unknown char for field " + c);
                return null;
        }
    }
}
