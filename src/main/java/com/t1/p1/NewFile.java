package com.t1.p1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class NewFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\com\\t1\\p1\\text.txt");

        System.out.println(file.isAbsolute());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.canRead());
        System.out.println(file.length());
        System.out.println(file.lastModified());

        File dir = new File("src\\main\\java\\com\\t1\\p1");
        System.out.println(dir.exists());
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        System.out.println(Arrays.toString(list));
        File[] listFiles = dir.listFiles();
        System.out.println(Arrays.toString(listFiles));
        System.out.println(dir.delete());
        File dir2 = new File("src\\main\\java\\com\\t1\\p1/p2");
        System.out.println(dir2.mkdir());
        File dir3 = new File("src\\main\\java\\com\\t1\\p1/p3/p4");
        System.out.println(dir3.mkdirs());
        System.out.println("================");

        File file2 = new File("src\\main\\java\\com\\t1\\p1\\text2.txt");
        System.out.println(file2.createNewFile());
        System.out.println(file2.delete());
        System.out.println(file2.createNewFile());


    }
}
