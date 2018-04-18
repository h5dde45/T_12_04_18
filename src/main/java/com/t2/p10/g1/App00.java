package com.t2.p10.g1;

import java.io.*;

public class App00 {

    public static void main(String[] args) throws IOException {
        byte[] data = "qwe asd".getBytes();
        try (ByteArrayInputStream in = new ByteArrayInputStream(data);
             FileOutputStream out = new FileOutputStream("src\\main\\java\\com\\t2\\p10\\g1\\text.txt")) {
            copy(in, out);
        }
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buff = new byte[256];
        while (true) {
            int count = in.read(buff);
            if (count == -1) {
                break;
            } else {
                out.write(buff,0,buff.length);
            }
        }
    }
}
