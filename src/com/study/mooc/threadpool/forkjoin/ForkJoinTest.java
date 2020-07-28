package com.study.mooc.threadpool.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 22:02
 */
public class ForkJoinTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SumTask task = new SumTask(1,10000000);
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> result = pool.submit(task);

        while (!task.isDone()){
            Thread.sleep(50);
            System.out.println("线程池线程数量："+pool.getPoolSize());
            System.out.println("线程并发："+pool.getParallelism());
            System.out.println("存活的线程："+pool.getActiveThreadCount());
        }
        System.out.println(result.get().toString());


    }
}
