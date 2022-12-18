package org.example.jdk.demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        // 创建一个自定义的线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);

// 创建一个并行流，使用自定义的线程池
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> {
                    // 这里是并行流的执行线程
                });
    }


}
