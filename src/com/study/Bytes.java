package com.study;

import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/6 9:32
 */
public class Bytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            byte b=scanner.nextByte();
            String bt = Integer.toBinaryString(b);
            String[] byteOnes=bt.split("0+");
            int max = 0;
            for(String byteOne:byteOnes){
                int currentLength = byteOne.length();
                if(max<currentLength){
                    max=currentLength;
                }
            }
            System.out.println(max);
        }
    }
}
