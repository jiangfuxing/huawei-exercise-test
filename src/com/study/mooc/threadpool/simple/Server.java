package com.study.mooc.threadpool.simple;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 21:11
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server(){
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void submitTask(Task task){
        System.out.println("一个新任务已经到来");
        executor.execute(task);
        System.out.println("当前线程池大小："+executor.getPoolSize());
        System.out.println("当前活动的线程："+executor.getActiveCount());
        System.out.println("当前完成的线程："+executor.getCompletedTaskCount());

    }

    public void endServer(){
        executor.shutdown();
    }
}
