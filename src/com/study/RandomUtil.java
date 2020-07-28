package com.study;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/10 23:25
 */
public class RandomUtil {
    public static int produceNumber(int n){
        return (int)(Math.random()*(n+1));
    }

    public static int produceNumber(int m,int n){
        return (int)(Math.random()*(n-m+1)+m);
    }

    public static void main(String[] args) {
        System.out.println("生成10[0-10]随机数");
        for(int i=0;i<10;i++){

            System.out.print(produceNumber(10)+" ");
        }
        System.out.println();
        System.out.println("生成10[2-8]随机数");
        for(int i=0;i<10;i++){
            System.out.print(produceNumber(2,8)+" ");
        }
    }

}
