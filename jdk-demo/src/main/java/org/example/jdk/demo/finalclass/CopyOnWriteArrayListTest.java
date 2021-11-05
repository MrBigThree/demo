package org.example.jdk.demo.finalclass;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/6/7
 */
public class CopyOnWriteArrayListTest implements Runnable {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();
        Thread thread = new Thread(new CopyOnWriteArrayListTest());
        //NEW
        System.out.println(thread.getState());
        thread.start();

        //RUNNABLE
        System.out.println(thread.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TERMINATED
        System.out.println(thread.getState());

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
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
