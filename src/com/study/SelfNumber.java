package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求指定范文内自首数个数
 */
public class SelfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int size = scanner.nextInt();
            int count = 0;
            for(int i=0;i<=size;i++){
                String self = String.valueOf(i);
                String sqrt = String.valueOf(i*i);
                int beginIndex = sqrt.length()-self.length();
                if(self.equals(sqrt.substring(beginIndex))){
                    count++;
                }
            }
            System.out.println(count);
            System.out.println();
        }
    }
}
