package charpter1.nio;

import com.sun.scenario.effect.impl.state.AccessHelper;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/5/18
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel channel;

    private volatile boolean stop;


    /**
     * @author lvxuhong
     * @description 初始化多路复用器
     * @date 9:45 上午 2020/5/18
     **/
    public MultiplexerTimeServer(int port) {
        try {
            this.selector = Selector.open();
            this.channel = ServerSocketChannel.open();
            this.channel.configureBlocking(false);
            this.channel.bind(new InetSocketAddress(port), 1024);
            this.channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the time server is start in port " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(selectionKey);
                    } catch (IOException e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //多路复用器关闭后，channel会自动关闭
        if (this.selector != null) {
            try {
                this.selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            if (selectionKey.isAcceptable()) {
                //接受新的请求
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                SocketChannel accept = channel.accept();
                accept.configureBlocking(false);
                accept.register(this.selector, SelectionKey.OP_READ);
            }
            if (selectionKey.isReadable()) {
                SocketChannel channel = (SocketChannel) selectionKey.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int read = channel.read(readBuffer);
                if (read > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("time server receive order :" + body);
                    String res = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date().toString() : "BAD ORDER";
                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                    writeBuffer.put(res.getBytes());
                    writeBuffer.flip();
                    channel.write(writeBuffer);
                }
            }
        }
    }

}
