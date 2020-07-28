package com.study.regextest;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/14 22:20
 */
public class Test1 {
    public static void main(String[] args) {
        String[] str = new String[]{"03/19/76","03-19-76","03.19.76"};
        String regex1 = "03[-/.]19[-/.]76";
        String regex2 = "03.19.76";
        for (String string:str){
            System.out.println(string+"匹配regex1结果为:"+(string.matches(regex1)));
            System.out.println(string+"匹配regex2结果为:"+(string.matches(regex2)));
        }

    }
}
