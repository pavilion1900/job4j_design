package ru.job4j.io;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    List<String> clientMsg = new ArrayList<>();
                    for (String str = in.readLine(); str != null && !str.isEmpty();
                         str = in.readLine()) {
                        clientMsg.add(str);
                        System.out.println(str);
                    }
                    out.flush();
                    String[] array = clientMsg.get(0).split(" ");
                    String[] subArray = array[1].split("=");
                    if ("Bye".equals(subArray[1])) {
                        socket.close();
                        server.close();
                    }
                }
            }
        }
    }
}
