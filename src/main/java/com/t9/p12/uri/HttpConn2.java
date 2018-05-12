package com.t9.p12.uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConn2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ya.ru/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.setConnectTimeout(1111);
            connection.connect();

            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
            System.out.println(connection.getContentType());
            System.out.println(connection.getContentLength());

            try (InputStream inputStream = url.openStream()) {
                new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                        .lines()
                        .forEach(System.out::println);
            }
        } finally {
            connection.disconnect();
        }
    }
}
