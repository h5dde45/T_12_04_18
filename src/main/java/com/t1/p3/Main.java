package com.t1.p3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            printUsageAndExit();
        }

        String cmd = args[0];
        Path archive = Paths.get(args[1]);
        Path directory = Paths.get(args[2]);

        switch (cmd) {
            case "pack":
                pack(archive, directory);
                break;
            case "unpack":
                unpack(archive, directory);
                break;
            default:
                printUsageAndExit();
        }
    }

    private static void unpack(Path archive, Path directory) {

    }

    private static void pack(Path archive, Path directory) {

    }

    private static void printUsageAndExit() {
        System.err.println("Usage: yar<pack|unpack> <archive> <dir>");
        System.exit(1);
    }
}
