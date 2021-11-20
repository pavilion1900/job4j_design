package ru.job4j.io;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                    if (str != null && !str.isEmpty()) {
                        String[] array = str.split(" ");
                        if ("Hello".equals(array[1].substring(6))) {
                            out.write("Hello\r\n\r\n".getBytes());
                        } else if ("Exit".equals(array[1].substring(6))) {
                            socket.close();
                            server.close();
                        } else {
                            out.write("What\r\n\r\n".getBytes());
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
