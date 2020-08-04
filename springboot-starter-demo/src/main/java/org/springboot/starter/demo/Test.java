package org.springboot.starter.demo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author:lvxuhong
 * @date:2020/7/27
 */
public class Test {

    private static volatile boolean isOver = false;

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("/Users/lvxuhong/logs/rocketmqlogs/000000"), "rw");
        randomAccessFile.setLength(1024);
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        System.out.println(totalMemory);
        System.out.println(freeMemory);
        MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, randomAccessFile.length());
        ByteBuffer byteBuffer = mappedByteBuffer.slice();
        byteBuffer.put("hello world".getBytes("UTF-8"));
        byteBuffer.put("你好".getBytes());
        mappedByteBuffer.force();
        randomAccessFile.close();

    }
}
