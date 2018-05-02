package com.t5.p12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serv {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);

        Socket accept = server.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

//        ObjectInputStream objectInputStream1 = new ObjectInputStream(inputStream);

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, "UTF-8"));

        for (int i = 1; i < 11; i++) {
            String s = bufferedReader.readLine();
            System.out.println("Line#" + i + " - " + s);
        }

        accept.close();

    }
}
