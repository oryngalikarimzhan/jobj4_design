package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if ("hello".equals(str.substring(9, 14).toLowerCase(Locale.ROOT))) {
                            out.write("hello".getBytes());
                            break;
                        } else if ("exit".equals(str.substring(9, 13).toLowerCase(Locale.ROOT))) {
                            server.close();
                            break;
                        } else {
                            out.write("What".getBytes());
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}