package com.t2.p11.g2;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RW {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\com\\t2\\p11\\g2\\text.txt");

        try (FileReader reader = new FileReader(file);
             CharArrayWriter writer = new CharArrayWriter()) {
            copy(reader, writer);
            System.out.println(writer.toString());
        }
    }

    private static void copy(FileReader reader, CharArrayWriter writer) throws IOException {
        char[] buff = new char[111];
        int count = 0;
        while ((count = reader.read(buff)) != -1) {
            writer.write(buff, 0, count);
        }
    }
}
