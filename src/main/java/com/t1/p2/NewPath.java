package com.t1.p2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewPath {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src\\main\\java\\com\\t1\\p2");
        System.out.println(path.isAbsolute());
        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(1));
        System.out.println(Files.isDirectory(path));

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)){
            for (Path child:paths){
                System.out.println(child);
            }
        }

        System.out.println("==============");
        Path file = Paths.get("src\\main\\java\\com\\t1\\p2\\NewPath.java");
        System.out.println(Files.exists(file));
        System.out.println(Files.isRegularFile(file));
        System.out.println(Files.isReadable(file));
        System.out.println(Files.size(file));
        System.out.println(Files.getLastModifiedTime(file).toMillis());

        System.out.println("==============");
        Path file2 = Paths.get("src\\main\\java\\com\\t1\\p2\\NewPath2.java");
        Files.delete(file2);
        System.out.println(Files.createFile(file2));
//        System.out.println(Files.createDirectory(Paths.get("src\\main\\java\\com\\t1\\p2\\pt2")));
//        System.out.println(Files.createDirectories(Paths.get("src\\main\\java\\com\\t1\\p2\\pt3/pt4")));
//        System.out.println(Files.copy(Paths.get("src\\main\\java\\com\\t1\\p2\\NewPath2.java"),
//                Paths.get("src\\main\\java\\com\\t1\\p2\\pt1/NewPath2.java")));
        System.out.println(Files.move(Paths.get("src\\main\\java\\com\\t1\\p2/pt1\\NewPath2.java"),
                Paths.get("src\\main\\java\\com\\t1\\p2\\pt2/NewPath2.java")));


    }
}
