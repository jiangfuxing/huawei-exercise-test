package com.study;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println(1e-3);*/
        while (scanner.hasNextDouble()){
            double y = scanner.nextDouble(); //利用牛顿迭代法求解立方根：
            double pow = pow(y, 1.0 / 3);
            System.out.println("用库函数求："+pow);
            double x = getNumberRoot(y,3);
            System.out.println(String.format("用牛顿迭代法求：%.1f",x));
        }
    }

    /**
     * 求一个数的N次方根
     * @param number 要求的数
     * @param n 次数
     * @return 方根
     */
    public static double getNumberRoot(double number,int n){
        double x = 1.0;
        for( ;abs(pow(x,n)-number)>pow(10,-3); x=x-((pow(x,n)-number)/(n*pow(x,(n-1))))); //1e-3=pow(10,-3)
        return x;
    }
}
