package org.example.jfinal.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/28
 */
public class Test {

    public static void main(String[] args) {

        try (DatagramSocket datagramSocket = new DatagramSocket(8089)) {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(datagramPacket);
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                System.out.println("接收到客户端的数据:" + str);
                String str1 = "我去洗澡了";
                InetSocketAddress address = (InetSocketAddress) datagramPacket.getSocketAddress();
                System.out.println(address.getHostName() + ":" + address.getPort());
                DatagramPacket dp1 = new DatagramPacket(str1.getBytes(), str1.getBytes().length, address);
                datagramSocket.send(dp1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
