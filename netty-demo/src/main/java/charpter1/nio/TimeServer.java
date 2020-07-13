package charpter1.nio;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MULTIPLEXER_TIMESERVER-001").start();
    }
}
