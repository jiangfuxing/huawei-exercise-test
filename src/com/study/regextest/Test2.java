package com.study.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION 把-i写在正则式之前标识忽略大小写
 * @date 2020/7/14 22:53
 */
public class Test2 {
    public static void main(String[] args) {
        String str1 = "colourcolorcolocolorcolrcolourourr";
        String regex ="colou?r";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str1);
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }
}
