package com.starsep.pphu;

import com.starsep.pphu.game.API;
import com.starsep.pphu.game.Bot;
import com.starsep.pphu.gui.MainWindow;
import com.starsep.pphu.io.IO;
import com.starsep.pphu.network.Connection;

import java.io.IOException;
import java.util.Objects;

public class Main {
    private static boolean gui(String[] args) {
        for (String arg : args) {
            if (Objects.equals(arg, "--gui")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Connection connection;
        try {
            if (args.length >= 1 && !args[0].startsWith("-")) {
                connection = new Connection(Integer.valueOf(args[0]));
            } else {
                connection = new Connection(Connection.PORT);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        API api = new API(connection);
        Bot bot = new Bot(api);
        if (gui(args)) {
            MainWindow.launchGUI(bot);
        }
        bot.play();
    }
}
