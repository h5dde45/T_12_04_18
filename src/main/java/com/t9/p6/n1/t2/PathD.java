package com.t9.p6.n1.t2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathD {
    public static void main(String[] args) {
        Path path = Paths.get("src\\main\\java\\com/t9/p6/n1/t2/text.txt");
        Path path2 = Paths.get(
                "C:\\java_projects\\2018\\T_12_04_18\\src\\main\\java\\com\\t9\\p6\\n1\\t2\\text.txt");
        System.out.println(path.isAbsolute());
        System.out.println(path2.isAbsolute());
        System.out.println(path.getNameCount());
        System.out.println(path2.getNameCount());
        System.out.println(path.getName(3));
        System.out.println(path2.getName(3));
        System.out.println(Files.exists(path));
        System.out.println(Files.exists(path2));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isRegularFile(path2));
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
