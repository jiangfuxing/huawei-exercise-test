package com.study;

import java.util.Scanner;

/**
 * 求首项为2，公差为3的前n项和
 * Sn=a1*n+n*(n-1)*d/2
 */
public class AlgothmSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int sum = (2*n)+((n*(n-1)*3)/2);
            System.out.println(sum);
        }
    }
}
