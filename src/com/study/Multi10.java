package com.study;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/9 18:52
 */
public class Multi10 {
   public static int recursive(int n){
       if(n==1){
           return n;
       }
       return n*recursive(n-1);

   }


    public static void main(String[] args) {

        System.out.println("循环方式："+loopWay(10));
        System.out.println("递归解决："+recursive(10));
    }

    /**
     * 循环方式
     * @param num
     * @return
     */
    public static int loopWay(int num){
        int result = 1;
        for(int i=1;i<=num;i++)
            result *= i;
        return result;
    }

}
