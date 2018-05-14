package com.t9.p7;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\java_projects\\2018\\T_12_04_18\\src\\main\\java\\com\\t7");

        try (Stream<Path> files = Files.walk(dir)) {
            long count = files
                    .filter(path -> path.toString().endsWith(".java"))
                    .peek(System.out::println)
                    .flatMap(Demo::getLines)
                    .filter(s -> s.contains("java"))
                    .peek(System.out::println)
                    .count();
            System.out.println(count);
        }
    }

    private static Stream<String> getLines(Path path)  {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
