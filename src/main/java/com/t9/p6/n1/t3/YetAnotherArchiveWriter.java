package com.t9.p6.n1.t3;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class YetAnotherArchiveWriter implements Closeable {
    private final DataOutputStream outputStream;

    public YetAnotherArchiveWriter(Path outputFile) throws IOException {
        this.outputStream = new DataOutputStream(Files.newOutputStream(outputFile,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING));
    }

    public void addDirectotyrecursively(Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                addFile(file, directory, attrs);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void addFile(Path file, Path directory, BasicFileAttributes attrs) throws IOException {
        outputStream.writeUTF(directory.relativize(file).toString());
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
