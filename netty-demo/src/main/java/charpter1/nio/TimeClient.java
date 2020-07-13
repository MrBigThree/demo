package charpter1.nio;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class TimeClient {
    public static void main(String[] args) {
        TimeClientHandler timeClientHandler = new TimeClientHandler("127.0.0.1", 8080);
        new Thread(timeClientHandler,"Time-Client-001").start();
    }
}
