package com.starsep.pphu.network;

import com.starsep.pphu.io.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
    private final String HOST = "papryka.pizza";
    public static final int PORT = 10020;
    private final String USERNAME = "team8";
    private final String PASSWORD = "6701923175";
    private Socket socket;
    private byte[] buffer = new byte[10000];

    public Connection(int port)  throws IOException {
        socket = new Socket(HOST, port);
        IO.err.print(getData());
        sendData(USERNAME);
        IO.err.print(getData());
        sendData(PASSWORD);
        IO.err.print(getData());
    }

    private String getData() throws IOException {
        InputStream inputStream = socket.getInputStream();
        StringBuilder result = new StringBuilder();
        do {
            int len = inputStream.read(buffer);
            for (int i = 0; i < len; i++) {
                result.append((char) buffer[i]);
            }
        } while (inputStream.available() > 0);
        String res = result.toString();
        IO.info("GOT " + res);
        return res;
    }

    private String get() throws IOException, ERRException {
        return expectOK(getData());
    }

    public void sendData(String data) throws IOException {
        String d = data + "\n";
        OutputStream out = socket.getOutputStream();
        IO.err.print("SENDING " + d);
        out.write(d.getBytes());
    }

    private String expectOK(String s) throws ERRException {
        if (!s.startsWith("OK")) {
            IO.error(s);
            throw new ERRException();
        }
        return s.replaceFirst("OK\n", "");
    }

    public String[] getLines(boolean log) throws IOException, ERRException {
        return get().split("\n");
    }

    public void getOK() throws IOException, ERRException {
        get();
    }
}
