package com.starsep.pphu.game.building;

import com.starsep.pphu.game.field.Field;

import java.awt.*;

public abstract class Building {
    public final int type;
    public final Field field;
    public Base base;

    public Building(int type, Base base, Field field) {
        this.type = type;
        this.base = base;
        this.field = field;
    }

    public int type() {
        return type;
    }
}
