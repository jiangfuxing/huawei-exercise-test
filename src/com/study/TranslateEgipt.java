package com.study;

import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/25 16:39
 */
public class TranslateEgipt {

    public static String toEgpt(String initNum){
        int sonNum = Integer.parseInt(initNum.split("\\/")[0]);
        int momNum = Integer.parseInt(initNum.split("\\/")[1]);
        //分子分母同时乘以10；
        String result  = getResult(sonNum,momNum);
        return result.substring(1);
    }

    private static String getResult(int sonNum, int momNum) {
        if(sonNum==1) return "+1/"+momNum;
        else {
            int x=0;
            if(momNum%sonNum == 0) x = momNum/sonNum;
            else x =(momNum/sonNum)+1;
            sonNum = sonNum*x-momNum;
            momNum = momNum*x;
            if(sonNum==0) return "+1/"+x;
            else return "+1/"+x+getResult(sonNum,momNum);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            System.out.println(toEgpt(input));
        }
    }
}
