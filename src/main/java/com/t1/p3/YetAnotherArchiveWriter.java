package com.t1.p3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class YetAnotherArchiveWriter implements AutoCloseable {
    private final DataOutputStream outputStream;

    public YetAnotherArchiveWriter(Path outputFile) throws IOException {
        this.outputStream = new DataOutputStream(Files.newOutputStream(
                outputFile, //file name to write
                StandardOpenOption.CREATE,//if the file does not create a new one
                StandardOpenOption.TRUNCATE_EXISTING//if the file exists, overwrite
        ));
    }

    public void addDirectoryRecursively(Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                addFile(file, directory, attrs);//add to archive
                return FileVisitResult.CONTINUE;//continue
            }
        });
    }

    private void addFile(Path file, Path directory, BasicFileAttributes attrs) throws IOException {
        outputStream.writeUTF(directory.relativize(file).toString());
        outputStream.writeLong(attrs.creationTime().toMillis());
        outputStream.writeLong(attrs.lastModifiedTime().toMillis());

        try (OutputStream embeddedOutputStream = new EmbeddedOutputStream(outputStream);) {
            Files.copy(file, embeddedOutputStream);
        }
    }

    @Override
    public void close() throws Exception {
        outputStream.close();
    }
}
