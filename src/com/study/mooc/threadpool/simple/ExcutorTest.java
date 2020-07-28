package com.study.mooc.threadpool.simple;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 21:10
 */
public class ExcutorTest {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        for(int i=0;i<100;i++){
            Task task = new Task("任务"+i);
            Thread.sleep(1000);
            server.submitTask(task);
        }
        server.endServer();
    }
}
