package com.t9.p12.uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConnectD {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ya.ru/");
        try (InputStream inputStream = url.openStream()) {
            new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .forEach(System.out::println);
        }
    }
}
