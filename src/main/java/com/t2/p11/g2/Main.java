package com.t2.p11.g2;

import com.t2.p10.g1.App00;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] bytes={100,101,102};
        File file = new File("src\\main\\java\\com\\t2\\p11\\g2\\text.txt");

        InputStream in = new ByteArrayInputStream(bytes);
        OutputStream out = new FileOutputStream(file);

        App00.copy(in, out);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(file);
        App00.copy(fis, bos);

        byte[] data = bos.toByteArray();
        System.out.println(Arrays.toString(data));
        System.out.println(new String(data));

    }
}
