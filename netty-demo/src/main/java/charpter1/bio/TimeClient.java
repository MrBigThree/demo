package charpter1.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description: 创建客户端
 * @author:lvxuhong
 * @date:2020/5/17
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        String host = "127.0.0.1";
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(),true);
            writer.println("QUERY TIME ORDER");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String res = reader.readLine();
            System.out.println("Now is " + res);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                writer.close();
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
