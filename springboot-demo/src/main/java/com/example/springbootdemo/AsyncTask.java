package com.example.springbootdemo;

import cn.hutool.core.date.DateUtil;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2022/2/28
 */
public class AsyncTask implements Runnable {

    private final AsyncContext asyncContext;

    public AsyncTask(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        ServletRequest request = asyncContext.getRequest();
        String userId = request.getParameter("userId");
        ServletResponse response = asyncContext.getResponse();
        try {
            Thread.sleep(1000);
            PrintWriter writer = response.getWriter();
            System.out.println("执行层线程id ：" + Thread.currentThread().getId() + ",时间戳：" + DateUtil.now() );
            writer.write("async hello");
            asyncContext.complete();
        } catch (IOException | InterruptedException exception) {
            //ignore
        }
    }
}
