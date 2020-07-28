package com.study;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/6 11:27
 */
public class CaseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            Pattern compile = Pattern.compile("[A-Z]+");
            Matcher matcher = compile.matcher(line);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()){
                stringBuffer.append(matcher.group());
            }
            System.out.println(stringBuffer.toString().length());
        }
    }
}
