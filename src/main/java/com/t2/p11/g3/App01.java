package com.t2.p11.g3;

import java.io.*;

public class App01 {
    public static void main(String[] args) throws IOException {
        try (
                DataOutputStream out =
                        new DataOutputStream(
                                new FileOutputStream(
                                        new File("src\\main\\java\\com\\t2\\p11\\g3\\text.txt")))) {
            out.writeDouble(4.4);
            out.writeShort(234);
            out.writeUTF("dfg");
        }
        try (
                DataInputStream in =
                        new DataInputStream(
                                new FileInputStream(
                                        new File("src\\main\\java\\com\\t2\\p11\\g3\\text.txt")))) {
            System.out.println(in.readDouble());
            System.out.println(in.readShort());
            System.out.println(in.readUTF());
        }

    }
}
