package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/24
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
//        FileOutputStream outputStream = null;
//        FileChannel channel = null;
//        try {
//            outputStream = new FileOutputStream("/Users/lvxuhong/logs/rocketmqlogs/000000");
//            channel = outputStream.getChannel();
//            channel.write(ByteBuffer.allocate(1), 1024);
//        } finally {
//            outputStream.close();
//            channel.close();
//        }

        //touchFixedLengthFile("/Users/lvxuhong/logs/rocketmqlogs/001024",1024);
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/lvxuhong/logs/rocketmqlogs/001024", "rw");
        byte[] bytes = "hello".getBytes();
        randomAccessFile.seek(5);
        randomAccessFile.write(bytes);
        // randomAccessFile.write(bytes, 0, bytes.length);
        System.out.println(bytes.length);
        randomAccessFile.close();
    }

    private static void touchFixedLengthFile(String filePath, long length) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        randomAccessFile.setLength(length);
        randomAccessFile.close();
    }
}
