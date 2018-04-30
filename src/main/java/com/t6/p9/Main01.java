package com.t6.p9;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[10];
        readFully(System.in, b);
        System.out.println(Arrays.toString(b));
    }

    private static void readFully(InputStream in, byte[] b) throws IOException {
        int offset = 0;
        while (offset < b.length) {
            int count = in.read(b, offset, b.length - offset);
            if (count == -1) {
                throw new IOException("Stream has less than " + b.length + " bytes");
            }
            offset += count;
        }
    }
}
