package com.study.questtion;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/12 19:21
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = s1.intern();
        String s4 = new String(s1);
        System.out.println("s1==s2:"+(s1==s2));
        System.out.println("s1==s3:"+(s1==s3));
        System.out.println("s3==s4:"+(s3==s4));

        int  t1 =2,t2 =3,t3;
        t3=t1>t2?t1:(t2+t1);
        System.out.println("t3="+t3);


    }
}
