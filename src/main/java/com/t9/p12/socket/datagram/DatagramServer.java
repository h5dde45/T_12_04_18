package com.t9.p12.socket.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket=new DatagramSocket(11111)){
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            while (true){
                socket.receive(packet);
                System.out.println(decodePacket(packet));
            }
        }
    }

    private static String decodePacket(DatagramPacket packet) {
        return new String(
                packet.getData(),
                packet.getOffset(),
                packet.getOffset()+packet.getLength(),
                StandardCharsets.UTF_8
        );
    }
}
