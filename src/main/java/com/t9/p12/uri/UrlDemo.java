package com.t9.p12.uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UrlDemo {
    public static void main(String[] args) throws IOException {
        URL url = UrlDemo.class.getResource("UrlDemo.class");
//        URL url = new URL("https://ya.ru/");
        System.out.println(url);
        try (InputStream inputStream = url.openStream()) {
            byte[] buffer = new byte[128];
            int read = inputStream.read(buffer);
            for (int i = 0; i < read; i++) {
                if (i % 32 == 0) {
                    System.out.println();
                }
                System.out.printf("%02X ", buffer[i]);
            }
        }
    }
}
