package com.t6.p9;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main02 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new URL("https://yandex.ru/").openStream();
        int v = 0;
        while ((v = inputStream.read()) != -1) {
            System.out.print((char) v);
        }
    }
}
