package com.starsep.pphu.io;

import java.io.PrintStream;

public class IO {
    public static final boolean LOG_POINTS = true;
    public static final boolean LOG_MAP = false;
    public static final boolean LOG_COSTS = false;
    public static final boolean LOG_MATCHES = false;
    public static final boolean RESOURCES = false;

    public static void error(String s) {
        System.err.print("\033[01;31mERROR: " + s + "\033[01;00m");
    }

    public static void info(String s) {
        System.err.print("\033[01;33mINFO: " + s + "\033[01;00m");
    }

    public static void success(String s) {
        System.err.print("\033[01;32mSUCCESS: " + s + "\033[01;00m");
    }
}
