package com.t9.p6.n1.t1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\java_projects\\2018\\T_12_04_18\\src\\main\\java\\com\\t9\\p6\\n1\\Main.java");
        File file2 = new File("src\\main\\java\\com\\t9\\p6\\n1");
        System.out.println(file.isAbsolute());
        System.out.println(file2.isAbsolute());
        System.out.println(file.getPath());
        System.out.println(file2.getPath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file2.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file2.exists());
        System.out.println(file.isFile());
        System.out.println(file2.isFile());
        System.out.println(file.canRead());
        System.out.println(file2.canRead());
        System.out.println(file.length());
        System.out.println(file2.length());
        System.out.println(file.lastModified());
        System.out.println(file2.lastModified());
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file2.list()));
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(Arrays.toString(file2.listFiles()));
        System.out.println();
    }
}