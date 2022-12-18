package com.example.springbootdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.AsyncContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/2/28
 */
@Component
public class ThreadPool {

    private ExecutorService threadPool;


    @PostConstruct
    public void initThreadPool(){
        this.threadPool = Executors.newFixedThreadPool(100);
    }

    public void process(AsyncContext asyncContext){
       AsyncTask task = new AsyncTask(asyncContext);
       threadPool.submit(task);
    }
}
