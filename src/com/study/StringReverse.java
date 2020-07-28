package com.study;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            StringBuffer sbf = new StringBuffer(scanner.nextLine());
            System.out.println(sbf.reverse());
        }
    }
}
