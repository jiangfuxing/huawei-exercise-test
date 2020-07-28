package com.study.mooc.threadpool.simple;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 21:15
 */
public class Task implements Runnable {
    private String name;

    public Task(String name){
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println(this.name+"正在执行...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
