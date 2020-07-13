package zerocopy;

import io.netty.util.concurrent.CompleteFuture;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author:lv·xuhong
 * @date:2020/6/24
 */
public class ZeroCopyTest {

    public static void main(String[] args) throws Exception {
//        FileChannel fileChannel = null;
//        FileChannel writeRandomAccessFileChannel = null;
//        try {
//            CompletableFuture
//            long startTime = System.currentTimeMillis();
//            File file = new File("/Users/lvxuhong/Downloads/elasticsearch-7.6.2-linux-x86_64.tar.gz");
//            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
//            fileChannel = randomAccessFile.getChannel();
//
//
//            File file1 = new File("/Users/lvxuhong/Downloads/elasticsearch-7.6.2-linux-x86_64.tar.gz.bak");
//            RandomAccessFile writeRandomAccessFile = new RandomAccessFile(file1, "rw");
//            writeRandomAccessFileChannel = writeRandomAccessFile.getChannel();
//
//            fileChannel.transferTo(0, fileChannel.size(), writeRandomAccessFileChannel);
//            long endTime = System.currentTimeMillis();
//            System.out.println(endTime - startTime);
//        } finally {
//            if (fileChannel != null) {
//                fileChannel.close();
//            }
//            if (writeRandomAccessFileChannel != null) {
//                writeRandomAccessFileChannel.close();
//            }
//
//        }
//
//
////        //map 映射到用户空间buffer
////        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
//
    }
}
