package org.example.jfinal.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/30
 */
public class Test2 {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            String str = "我是客户端，要发送消息";
            byte[] buf = str.getBytes();
            int port = 8089;//服务器端的端口
            String ip = "20.21.1.118";//服务器端的ip地址140.143.245.229
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), port);
            datagramSocket.send(datagramPacket);
            System.out.println("给服务端发送数据");
            while (true){
                DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(datagramPacket1);
                String rec = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
                System.out.println("收到回复:" + rec);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
