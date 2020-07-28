package com.study.mooc.threadpool.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 22:04
 */
public class SumTask extends RecursiveTask<Long> {
    private int start;

    private int end;

    public SumTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum = 0L;
        if(end-start <= 5){
            for(int i=start; i<=end; i++){
                sum += i;
            }
        }else {
            int middle = (start+end)/2;
            SumTask sumTask1 = new SumTask(start,middle);
            SumTask sumTask2 = new SumTask(middle+1,end);
            invokeAll(sumTask1,sumTask2);

            sum = sumTask1.join()+sumTask2.join();
        }
        return sum;
    }
}
