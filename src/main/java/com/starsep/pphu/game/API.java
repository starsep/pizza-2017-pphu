package com.starsep.pphu.game;

import com.starsep.pphu.gui.GUI;
import com.starsep.pphu.io.IO;
import com.starsep.pphu.network.Connection;
import com.starsep.pphu.network.ERRException;

import java.io.IOException;

public class API {
    public static final int INVALID_INT = -1;
    private Connection connection;
    private GUI gui;

    public API(Connection connection) {
        this.connection = connection;
    }

    public int getTurnsLeft() {
        try {
            connection.sendData("GET_TURNS_LEFT");
            return getInt();
        } catch (Exception e) {
            return INVALID_INT;
        }
    }

    private int[] parseInts(String s) {
        String[] ss = s.split(" ");
        int[] res = new int[ss.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.valueOf(ss[i]);
        }
        return res;
    }

    Map getMap() {
        try {
            connection.sendData("GET_MAP");
            String[] s = connection.getLines(IO.LOG_MAP);
            String[] result = new String[s.length - 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = s[i + 1];
            }
            return new Map(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getInt() throws IOException, ERRException {
        String firstLine = connection.getLines(true)[0];
        return parseInts(firstLine)[0];
    }

    int setBase(int match, int row, int col, int founder) {
        try {
            connection.sendData(String.format("SET_BASE %d %d %d %d", match, row, col, founder));
            return getInt();
        } catch (Exception e) {
            return INVALID_INT;
        }
    }

    boolean build(int match, int type, int row, int col) {
        try {
            connection.sendData(String.format("BUILD %d %d %d %d", match, type, row, col));
            connection.getOK();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    int[] getMyMatches() {
        try {
            connection.sendData("GET_MY_MATCHES");
            return parseInts(connection.getLines(IO.LOG_MATCHES)[1]);
        } catch (Exception e) {
            return null;
        }
    }

    Resources[] getMyResources(int match) {
        try {
            connection.sendData(String.format("GET_MY_RESOURCES %d", match));
            String[] lines = connection.getLines(IO.RESOURCES);
            Resources[] result = new Resources[lines.length - 1];
            for (int i = 0; i < result.length; i++) {
                result[i] = new Resources(parseInts(lines[i + 1]));
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    int[][] getCosts() {
        try {
            connection.sendData("GET_COSTS");
            String[] lines = connection.getLines(IO.LOG_COSTS);
            int[][] result = new int[lines.length][];
            for (int i = 0; i < result.length; i++) {
                result[i] = parseInts(lines[i]);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    boolean sell(int match, int base, int alu, int coal, int sil, int uran) {
        try {
            connection.sendData(String.format("SELL %d %d %d %d %d %d", match, base, alu, coal, sil, uran));
            connection.getOK();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int[] getPoints(int match) {
        try {
            connection.sendData(String.format("GET_POINTS %d", match));
            String[] lines = connection.getLines(IO.LOG_POINTS);
            return parseInts(lines[0]);
        } catch (Exception e) {
            return null;
        }
    }

    public void setGUI(GUI gui) {
        this.gui = gui;
    }
}
