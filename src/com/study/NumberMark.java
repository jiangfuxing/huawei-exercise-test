package com.study;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            input=input.replaceAll("\\d+","\\*$0\\*");
            System.out.println(input);
        }
    }
}
