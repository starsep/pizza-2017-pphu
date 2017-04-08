package com.starsep.pphu.game.building;

import com.starsep.pphu.game.field.Field;

public class Base extends Building {
    public final int id;

    public Base(int id, Field field) {
        super(BuildingType.BASE, null, field);
        base = this;
        this.id = id;
    }
}
