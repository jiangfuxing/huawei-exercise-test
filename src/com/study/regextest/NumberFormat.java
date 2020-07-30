package com.study.regextest;

import java.util.Scanner;

/**
 * 为一个数每隔三位添加逗号
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/30 22:28
 */
public class NumberFormat {
    public static void main(String[] args) {
        String regex = "(?<=\\d)(?=(\\d\\d\\d)+$)"; //正则式环视的用法：(?<= \\d)表示任意一个数字后面的位置，
        String comma = ",";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            input=input.replaceAll(regex,comma);
            System.out.println(input);
        }
    }
}
