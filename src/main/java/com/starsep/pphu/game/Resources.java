package com.starsep.pphu.game;

public class Resources {
    public final int base;
    public final int alu;
    public final int coal;
    public final int sil;
    public final int uran;

    public Resources(int[] r) {
        base = r[0];
        alu = r[1];
        coal = r[2];
        sil = r[3];
        uran = r[4];
    }

    public int[] toArray() {
        return new int[]{base, alu, coal, sil, uran};
    }
}
